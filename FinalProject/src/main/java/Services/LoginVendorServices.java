package Services;

import Model.User;

public interface LoginVendorServices {
	User login(String name, String password);
}
