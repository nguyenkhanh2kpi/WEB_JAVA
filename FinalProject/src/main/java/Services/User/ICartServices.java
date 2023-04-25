package Services.User;

import java.util.List;

import Model.Cart;
import Model.CartItem;

public interface ICartServices {
	List<Cart> findCartByUserId(int userId);
	void insert(Cart cart);
	Cart getCart(int UserId, int StoreId);
	List<CartItem> findAllCartItem();
	List<CartItem> findCartItembyCartId(int id);
	void insertItem(CartItem cartItem);
	void delete(int cartId,int productId);
	void updateQuantity(CartItem cartItem);
	CartItem checkItemInCart(CartItem cartItem);
}
