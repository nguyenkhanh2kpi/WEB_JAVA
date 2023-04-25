package DAO.User.UserDaoImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.Connection;
import DAO.User.ICartUserDAO;
import Model.Cart;
import Model.CartItem;

public class CartUserImpl extends Connection implements ICartUserDAO{

	@Override
	public List<Cart> findCartbyUserId(int userId) {
		// TODO Auto-generated method stub
		List<Cart> carts = new ArrayList<Cart>();
		String sql = "SELECT * from Cart Where userId=?";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cart cart = new Cart();
				cart.setId(rs.getInt("id"));
				cart.setUserId(rs.getInt("userId"));
				cart.setStoreId(rs.getInt("storeId"));
				carts.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carts;
	}

	@Override
	public void insert(Cart cart) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Cart (userId, StoreId)"
				+ "VALUES (?,?)";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cart.getUserId());
			ps.setInt(2, cart.getStoreId());
			ps.executeUpdate();
			} 
		catch (Exception e) {
			e.printStackTrace();}
	}
	@Override
	public List<CartItem> findAllCartItem() {
		// TODO Auto-generated method stub
		List<CartItem> cartItems = new ArrayList<CartItem>();
		String sql = "SELECT * from CartItem";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CartItem cartItem = new CartItem();
				cartItem.setId(rs.getInt("id"));
				cartItem.setCartId(rs.getInt("cartId"));
				cartItem.setProductId(rs.getInt("productId"));
				cartItem.setCount(rs.getInt("count"));
				cartItems.add(cartItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartItems;
	}

	@Override
	public void insertItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO CartItem (cartId, productId,count)"
				+ "VALUES (?,?,?)";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cartItem.getCartId());
			ps.setInt(2, cartItem.getProductId());
			ps.setInt(3, cartItem.getCount());
			ps.executeUpdate();
			} 
		catch (Exception e) {
			e.printStackTrace();}
		
	}

	@Override
	public void delete(int cartId,int productId) {
		String sql = "Delete from CartItem where cartId = ? and productId=?";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cartId);
			ps.setInt(2, productId);
			ps.executeUpdate();
			} 
		catch (Exception e) {
			e.printStackTrace();}
		
	}

	@Override
	public void updateQuantity(CartItem cartItem) {
		// TODO Auto-generated method stub
		String sql = "UPDATE CartItem SET count=? Where cartId = ? and productId=?";
		try {
			java.sql.Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cartItem.getCount());
			ps.setInt(2, cartItem.getCartId());
			ps.setInt(3, cartItem.getProductId());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Cart getCart(int UserId, int StoreId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * from Cart Where userId=? and storeId=?";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, UserId);
			ps.setInt(2, StoreId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cart cart = new Cart();
				cart.setId(rs.getInt("id"));
				cart.setUserId(rs.getInt("userId"));
				cart.setStoreId(rs.getInt("storeId"));
				return cart;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CartItem checkItemInCart(CartItem cartItem) {
		// TODO Auto-generated method stub
		String sql = "Select * from CartItem where cartId = ? and productId=?";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cartItem.getCartId());
			ps.setInt(2, cartItem.getProductId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CartItem cartItem1 = new CartItem();
				cartItem1.setId(rs.getInt("id"));
				cartItem1.setCartId(rs.getInt("cartId"));
				cartItem1.setProductId(rs.getInt("productId"));
				cartItem1.setCount(rs.getInt("count"));
				return cartItem1;
			}
		}
		catch (Exception e) {
			e.printStackTrace();}
		return null;
	}

	@Override
	public List<CartItem> findCartItembyCartId(int id) {
		// TODO Auto-generated method stub
		List<CartItem> cartItems = new ArrayList<CartItem>();
		String sql = "SELECT * from CartItem where cartId=?";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CartItem cartItem = new CartItem();
				cartItem.setId(rs.getInt("id"));
				cartItem.setCartId(rs.getInt("cartId"));
				cartItem.setProductId(rs.getInt("productId"));
				cartItem.setCount(rs.getInt("count"));
				cartItems.add(cartItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartItems;
	}
}
