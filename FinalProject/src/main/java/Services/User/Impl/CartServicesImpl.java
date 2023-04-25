package Services.User.Impl;

import java.util.List;

import DAO.User.ICartUserDAO;
import DAO.User.UserDaoImpl.CartUserImpl;
import Model.Cart;
import Model.CartItem;
import Services.User.ICartServices;

public class CartServicesImpl implements ICartServices{
	ICartUserDAO cartDao = new CartUserImpl();

	@Override
	public List<Cart> findCartByUserId(int userId) {
		// TODO Auto-generated method stub
		return cartDao.findCartbyUserId(userId);
	}

	@Override
	public void insert(Cart cart) {
		// TODO Auto-generated method stub
		cartDao.insert(cart);
		return;
	}

	@Override
	public List<CartItem> findAllCartItem() {
		// TODO Auto-generated method stub
		return cartDao.findAllCartItem();
	}

	@Override
	public void insertItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartDao.insertItem(cartItem);
		return;
		
	}

	@Override
	public void delete(int cartId,int productId) {
		// TODO Auto-generated method stub
		cartDao.delete(cartId,productId);
		
	}

	@Override
	public void updateQuantity(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartDao.updateQuantity(cartItem);
	}

	@Override
	public Cart getCart(int UserId, int StoreId) {
		// TODO Auto-generated method stub
		return cartDao.getCart(UserId, StoreId);
	}

	@Override
	public CartItem checkItemInCart(CartItem cartItem) {
		// TODO Auto-generated method stub
		return cartDao.checkItemInCart(cartItem);
	}

	@Override
	public List<CartItem> findCartItembyCartId(int id) {
		// TODO Auto-generated method stub
		return cartDao.findCartItembyCartId(id);
	}
	
}
