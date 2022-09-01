package com.example.demo.services.User;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.CartRepository;
import com.example.demo.Repository.Content_detailsRepository;
import com.example.demo.entity.Cart;
import com.example.demo.entity.ContentDetails;

@Service
public class AddtoCartService {

	@Autowired
	CartRepository cartrepo;

	@Autowired
	Content_detailsRepository conRepo;

	public Cart savetoCart(Cart cart) {
		System.out.println("id:: " + cart.getLoginid());
		if (cart.getLoginid().isEmpty()) {

			cart.setLoginid("-1");
			System.out.println("id:: " + cart.getLoginid());
		}
		Cart save = cartrepo.save(cart);
		return save;
	}

	public List<ContentDetails> findUserCart(String user) {

		List<ContentDetails> d = new ArrayList<ContentDetails>();
		System.out.println("Content details list " + d);
		List<Cart> findByLoginid = cartrepo.findByLoginid(user);
		for (Cart c : findByLoginid) {
			ContentDetails findByContentid = conRepo.findByContentid(Integer.parseInt(c.getContentid()));
			findByContentid.setCartid(c.getCartid());
			findByContentid.setContentids(c.getContentid());
			System.out.println(findByContentid.getContentid() + "    " + c.getContentid());
			d.add(findByContentid);
			System.out.println("details new list " + d);
		}
		return d;
	}

	public List<Cart> cartDetails(String user) {
		List<Cart> findByLoginid = cartrepo.findByLoginid(user);
		return findByLoginid;
	}

	public ContentDetails findSingleContent(String contentid) {

		ContentDetails findByContentid = conRepo.findByContentid(Integer.parseInt(contentid));
		return findByContentid;
	}

	public void deleteByid(int id) {
		System.out.println("delete ");
		cartrepo.deleteById(id);
	}

	public void deleteAll(String email, String contentid) {

		System.out.println("delete");
		String[] id = contentid.split("\\s");
		int deleteByLoginidAndTitle=0;
		for (String w : id) {
			 deleteByLoginidAndTitle = cartrepo.deleteByLoginidAndContentid(email, w);
		}
		System.out.println("delete :: " + deleteByLoginidAndTitle);
	}
}