package DAO.User;

import java.util.List;

import Model.Cart;
import Model.CartItem;

public interface ICartUserDAO {
	List<Cart> findCartbyUserId(int userId);
	Cart getCart(int UserId, int StoreId);
	void insert(Cart cart);
	List<CartItem> findAllCartItem();
	List<CartItem> findCartItembyCartId(int id);
	void insertItem(CartItem cartItem);
	void delete(int cartId,int productId);
	void updateQuantity(CartItem cartItem);
	CartItem checkItemInCart(CartItem cartItem);
	
}
