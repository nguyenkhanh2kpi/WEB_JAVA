package Model;

public class Category {
		private int id;
		private String name;
		private String slug;
		private String image;
		public Category() {
		}
		public Category(int id, String name, String slug, String image) {
			this.id = id;
			this.name = name;
			this.slug = slug;
			this.image = image;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSlug() {
			return slug;
		}
		public void setSlug(String slug) {
			this.slug = slug;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		@Override
		public String toString() {
			return "Category [id=" + id + ", name=" + name + ", slug=" + slug + ", image=" + image + "]";
		}
		
		
		

}