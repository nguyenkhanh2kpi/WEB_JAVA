Create database TMDT
USE TMDT
GO
 GO
      ALTER DATABASE TMDT    
      SET RECURSIVE_TRIGGERS OFF 
GO

CREATE TABLE Role_user
(
	id INT IDENTITY PRIMARY KEY,
	role_name nvarchar(100)
)

insert into Role_user values('user')
insert into Role_user values('vendor')
insert into Role_user values('admin')

CREATE TABLE _User
(
   id INT IDENTITY PRIMARY KEY,
   id_role int references  ROLE_USER(id),
   full_name NVARCHAR(50) NOT NULL,
   slug NVARCHAR(32) UNIQUE,
   id_card NVARCHAR(32) UNIQUE,
   phone NVARCHAR(32) UNIQUE,
   password NVARCHAR(32),
   avatar NVARCHAR(32),
   point INT not null default 0,
   isActive BIT not null default 1,
   createdAt DATE,
   updatedAt DATE
)
GO

insert into _User(id_role,full_name,slug,id_card,phone,password,avatar,createdAt) 
values (2,N'Nguyễn','nguyen','123345253','0123456789','123','1.png','1-1-2022')

insert into _User(id_role,full_name,slug,id_card,phone,password,avatar,createdAt) 
values (2,N'Nguyễn Lê Quốc Khánh','nguyen-le-quoc-khanh','122245253','0123456788','123','1.png','1-1-2022')

insert into _User(id_role,full_name,slug,id_card,phone,password,avatar,createdAt) 
values (2,N'Phạm Hùng','pham-hung','123347353','0123456787','123','1.png','1-1-2022')

insert into _User(id_role,full_name,slug,id_card,phone,password,avatar,createdAt) 
values (1,N'Khách Nguyễn Nam ','nguyen-nam','123347352','0123456000','123','1.png','1-1-2022')


CREATE TABLE Commission
(
   id INT IDENTITY PRIMARY KEY,
   name NVARCHAR(32) UNIQUE,
   cost DECIMAL UNIQUE
)
GO

insert into Commission values ('3%', 3)
insert into Commission values ('5%', 5)
go

CREATE TABLE Store
(
   id INT IDENTITY PRIMARY KEY,
   name NVARCHAR(100),
   bio NVARCHAR(100),
   slug NVARCHAR(32) UNIQUE,
   ownerId INT references _USER(id),
   isActive BIT not null default 1,
   avatar NVARCHAR(32),
   commissionId int references Commission(id),
   e_wallet DECIMAL,
   createdAt DATE,
   updatedAt DATE
)
GO

insert into Store (name,bio,slug,ownerId,isActive,avatar,commissionId,e_wallet,createdAt,updatedAt) values (N'Khánh Store',N'bán điện thoại cũ','nguyen-khanh',1,1,'1.jpg',1,100000,'1-1-22','1-1-22')
insert into Store (name,bio,slug,ownerId,isActive,avatar,commissionId,e_wallet,createdAt,updatedAt) values (N'Hai Store',N'bán laptop','lap-top-my',1,0,'1.jpg',2,100000,'1-1-22','1-1-22')
insert into Store (name,bio,slug,ownerId,isActive,avatar,commissionId,e_wallet,createdAt,updatedAt) values (N'Hung Store',N'bán laptop','lap-top-hung',2,0,'1.jpg',2,100000,'1-1-22','1-1-22')

go

CREATE TABLE Category
(
   id INT IDENTITY PRIMARY KEY,
   name NVARCHAR(32) UNIQUE,
   slug NVARCHAR(32) UNIQUE,
   image NVARCHAR(32)
)
GO

insert into Category (name,slug) values (N'Điện thoại', 'dien-thoai')
insert into Category (name,slug) values (N'Máy tính bảng', 'may-tinh-bang')
insert into Category (name,slug) values (N'LapTop ', 'lap-top')
insert into Category (name,slug) values (N'Máy tính để bàn ', 'may-ban')
insert into Category (name,slug) values (N'Ti-vi,  m thanh ', 'tivi-amthanh')

CREATE TABLE Product
(
  id INT IDENTITY PRIMARY KEY,
  name NVARCHAR(32),
  slug NVARCHAR(32) UNIQUE,
  description NVARCHAR(255),
  price DECIMAL,
  quantity INT,
  sold INT not null default 0,
  isActive BIT not null default 1,
  images NVARCHAR(100),
  categoryId int references Category(id),
  storeId int references Store(id) ON DELETE CASCADE
)
GO
insert into Product(name,slug,description,price,quantity,images,categoryId,storeId) 
values ('samsung s22','sam-sung-s22','no des',10000000,30,'1.png',1,1)

insert into Product(name,slug,description,price,quantity,images,categoryId,storeId) 
values ('samsung s21','sam-sung-s21','no des',10000000,30,'1.png',1,1)

insert into Product(name,slug,description,price,quantity,images,categoryId,storeId) 
values ('samsung s22','sam-sung-s22-1','no des',10000000,30,'1.png',1,2)

insert into Product(name,slug,description,price,quantity,images,categoryId,storeId) 
values ('samsung s21','sam-sung-s21-1','no des',10000000,30,'1.png',1,2)

CREATE TABLE Delivery
(
  id INT IDENTITY PRIMARY KEY,
  name NVARCHAR(32) UNIQUE,
  description NVARCHAR(32),
  price INT,
  isDeleted BIT default 0
)

GO
insert into Delivery(name,description, price) values('10km-500g','no1',5000)
insert into Delivery(name,description, price) values('20km-500g','no2',10000)
insert into Delivery(name,description, price) values('40km-500g','no3',15000)
insert into Delivery(name,description, price) values('10km-700g','no4',7000)
insert into Delivery(name,description, price) values('20km-700g','no5',12000)
insert into Delivery(name,description, price) values('40km-700g','no6',17000)
insert into Delivery(name,description, price) values('10km-1kg','no7',10000)
insert into Delivery(name,description, price) values('20km-1kg','no8',15000)
insert into Delivery(name,description, price) values('40km-1kg','no9',19000)

CREATE TABLE _Order
(
  id INT IDENTITY PRIMARY KEY,
  userId INT references _USER(id),
  deliveryId INT references Delivery(id),
  StoreId INT references Store(id),
  commissionId INT references Commission(id),
  address NVARCHAR(32),
  phone NVARCHAR(12),
  status NVARCHAR(32)not null default 'wait_confirmation' CHECK (status IN('wait_confirmation', 'wait_goods', 'delivering','delivered')),
  isPaidBefore BIT not null default 0,
  amountFromUser DECIMAL null, 
  amountFromStore DECIMAL null,
  amountToStore DECIMAL null,
  amountToGD DECIMAL null,
  createdAt DATE,
  updatedAt DATE
)
GO


insert into _Order(userId,deliveryId,StoreId,commissionId,address,phone,status)
values (4,1,1,1,'quan 9','1234567345','wait_goods')
insert into _Order(userId,deliveryId,StoreId,commissionId,address,phone,status)
values (4,1,1,1,'quan 2','1234567853','delivering')
insert into _Order(userId,deliveryId,StoreId,commissionId,address,phone,status)
values (4,1,1,1,'quan 7','1234567853','wait_confirmation')
insert into _Order(userId,deliveryId,StoreId,commissionId,address,phone,status)
values (4,1,1,1,'thu duc','1234567835','delivering')
insert into _Order(userId,deliveryId,StoreId,commissionId,address,phone,status)
values (4,1,1,1,'go vap','1234567835','delivering')


insert into _Order(userId,deliveryId,StoreId,commissionId,address,phone,status, amountToStore, updatedAt)
values (4,1,2,1,'Nguyen Thai Son go vap ','1234567835','delivered',10000000,'1-2-22')
insert into _Order(userId,deliveryId,StoreId,commissionId,address,phone,status, amountToStore, updatedAt)
values (4,1,2,1,'1 Nguyen Thai Son go vap ','1234567836','delivered',15000000,'2-3-22')
insert into _Order(userId,deliveryId,StoreId,commissionId,address,phone,status, amountToStore, updatedAt)
values (4,1,2,1,'2c Nguyen Thai Son go vap ','1234567837','delivered',20000000,'4-5-22')
insert into _Order(userId,deliveryId,StoreId,commissionId,address,phone,status, amountToStore, updatedAt)
values (4,1,2,1,'3 Nguyen Thai Son go vap ','1234567838','delivered',100000000,'6-7-22')
go


go
CREATE TABLE OrderItem
(
  id INT IDENTITY PRIMARY KEY,
  productId INT references Product(id),
  orderId INT references _Order(id),
  count INT
)
GO

insert into OrderItem(productId,orderId,count) values(1,1,1)
insert into OrderItem(productId,orderId,count) values(2,1,8)
insert into OrderItem(productId,orderId,count) values(3,1,6)
insert into OrderItem(productId,orderId,count) values(1,2,1)
insert into OrderItem(productId,orderId,count) values(4,2,2)
insert into OrderItem(productId,orderId,count) values(3,3,1)
insert into OrderItem(productId,orderId,count) values(4,3,1)
insert into OrderItem(productId,orderId,count) values(2,4,2)
insert into OrderItem(productId,orderId,count) values(3,4,7)


insert into OrderItem(productId,orderId,count) values(2,4,2)
insert into OrderItem(productId,orderId,count) values(3,5,7)
insert into OrderItem(productId,orderId,count) values(2,5,2)
insert into OrderItem(productId,orderId,count) values(3,6,7)
insert into OrderItem(productId,orderId,count) values(2,7,2)
insert into OrderItem(productId,orderId,count) values(3,7,7)
insert into OrderItem(productId,orderId,count) values(2,8,2)
insert into OrderItem(productId,orderId,count) values(3,9,7)
insert into OrderItem(productId,orderId,count) values(2,9,2)
insert into OrderItem(productId,orderId,count) values(3,9,7)


CREATE TABLE Cart
(
  id INT IDENTITY PRIMARY KEY,
  userId INT references _USER(id),
  StoreId INT references Store(id),
)
GO

Create TABLE CartItem
(
  id INT IDENTITY PRIMARY KEY,
  cartId INT references Cart(id),
  productId INT references Product(id),
  count INT
)
GO

CREATE TABLE _Transaction
(
  id INT IDENTITY PRIMARY KEY,
  userId INT references _USER(id),
  storeId INT references Store(id),
  isUp BIT default 0,
  amount DECIMAL,
  createdAt  date,
  updatedAt date
)
go
insert into _Transaction (userId,StoreId,isUp,amount,createdAt,updatedAt) values (1,1,1,10000000,'1-1-22','1-1-22')
go
CREATE TABLE subProduct (
	id int IDENTITY(1,1) primary key,
	productName nvarchar(50),
	productId int FOREIGN KEY REFERENCES Product(id),
	userId int FOREIGN KEY REFERENCES _User(id)
)
GO
CREATE TABLE subStore (
	id int IDENTITY(1,1) primary key,
	shopName nvarchar(50),
	storeId int FOREIGN KEY REFERENCES Store(id),
	userId int FOREIGN KEY REFERENCES _User(id)
)
GO

go
create trigger trg_TimeCreateTrans on _Transaction for insert as
begin 
	declare @idTrans int
	declare @idStore int
	declare @idUp bit
	declare @Amount int
	select @idTrans = id,@idStore = storeId,@idUp=isUp,@Amount=amount from inserted
	update _Transaction 
	set
		createdAt= GETDATE()
	from _Transaction
	where _Transaction.id=@idTrans
	if @idUp=1
	begin 
		update Store
		set
			e_wallet=e_wallet+@Amount
		from Store
		where Store.id=@idStore
	end
	else 
	begin 
		update Store
		set
			e_wallet=e_wallet-@Amount
		from Store
		where Store.id=@idStore
	end
end
go


create trigger trg_TimeCreateStore on Store for insert as
begin 
	declare @idStore int
	select @idStore = id from inserted
	update Store 
	set
		createdAt= GETDATE()
	from Store
	where Store.id=@idStore
end
go

create trigger trg_TimeUpdateStore on Store for update as
begin 
	declare @idStore int
	select @idStore = id from inserted
	update Store 
	set
		updatedAt= GETDATE() 
	from Store
	where Store.id=@idStore
end
go


create trigger trg_TimeCreateOder on _Order for insert as
begin 
	declare @idOrder int
	select @idOrder = id from inserted
	update _Order 
	set
		createdAt= GETDATE()
	from _Order
	where _Order.id=@idOrder
end
go

create trigger trg_TimeUpdateOrder on _Order for update as
begin 
	declare @idOrder int
	select @idOrder = id from inserted
	update _Order 
	set
		updatedAt= GETDATE() 
	from _Order
	where _Order.id=@idOrder
end
go

go
create proc sp_SelectOrder
(
	@StoreId nvarchar(30),
	@status nvarchar(30)
)
as
begin
	if(@status IN('wait_confirmation', 'wait_goods', 'delivering','delivered') )
		select * from _Order where StoreId=@StoreId and status=@status
	else
		select * from _Order where StoreId=@StoreId
end;
go



create proc sp_delivered
(
@id int,
@status nvarchar(50)
)
as
begin
	if @status='delivered'
	begin
		update _Order 
		set
		amountFromUser = ((select price from _Order join Delivery on _Order.deliveryId=Delivery.id and _Order.id=@id) + (select sum(Product.price*OrderItem.count) as sumOrder from OrderItem join Product on Product.id=OrderItem.productId where OrderItem.orderId=@id)),
		amountFromStore = ((select sum(Product.price*OrderItem.count) as sumOrder from OrderItem join Product on Product.id=OrderItem.productId where OrderItem.orderId=@id)*
		(select cost*0.01 from _Order join Commission on _Order.commissionId=Commission.id where _Order.id=@id)),
		amountToStore = ((select sum(Product.price*OrderItem.count) as sumOrder from OrderItem join Product on Product.id=OrderItem.productId where OrderItem.orderId=@id)*
		(select (100-cost)*0.01 from _Order join Commission on _Order.commissionId=Commission.id where _Order.id=@id)),
		amountToGD =((select sum(Product.price*OrderItem.count) as sumOrder from OrderItem join Product on Product.id=OrderItem.productId where OrderItem.orderId=@id)*
		(select cost*0.01 from _Order join Commission on _Order.commissionId=Commission.id where _Order.id=@id))
		from _Order
		where _Order.id=@id
	end
end
go



create proc sp_income_thisyear
(
	@UserID int
)
as
begin
	select Store.ownerId as StoreUserID, _Order.id as orderId, _Order.userId as OrderUserID,
	_Order.amountToStore as income, _Order.updatedAt as completeDate
	from Store join _Order on Store.id=_Order.StoreId
	where _Order.status='delivered' and Store.ownerId=@UserID
end;
go


go
create function FindProduct
(	@ProductName NVARCHAR(50))
RETURNs table
AS return select * from Product where name like '%' + @ProductName + '%'
go

