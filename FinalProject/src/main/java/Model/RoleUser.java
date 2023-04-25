package Model;

public class RoleUser {
	private int id;
	private String roleName;
	public RoleUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoleUser(int id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "RoleUser [id=" + id + ", roleName=" + roleName + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
