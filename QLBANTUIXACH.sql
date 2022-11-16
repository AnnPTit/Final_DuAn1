CREATE DATABASE QLBANTUIXACH 
GO 
USE QLBANTUIXACH
GO 
CREATE TABLE SanPham (
ID INT identity (1,1) not null  , 
MaSP VARCHAR(10) , 
TenSP NVARCHAR(50),
NgayTao DATE,
NgaySua DATE,
TrangThai INT , 
CONSTRAINT PK_SP PRIMARY KEY(ID)
)
GO 


CREATE TABLE Mau (
ID INT identity (1,1) not null  , 
MaMau VARCHAR(10) , 
TenMau NVARCHAR(50),
NgayTao DATE,
NgaySua DATE,
TrangThai INT , 
CONSTRAINT PK_MAU PRIMARY KEY(ID)
)
go

CREATE TABLE DanhMuc (
ID INT identity (1,1) not null  , 
MaDM VARCHAR(10) , 
TenDM NVARCHAR(50), 
NgayTao DATE,
NgaySua DATE,
TrangThai INT , 
CONSTRAINT PK_DM PRIMARY KEY(ID)
)
go

CREATE TABLE ChatLieu (
ID INT identity (1,1) not null  , 
MaCL VARCHAR(10) , 
TenCL NVARCHAR(50), 
NgayTao DATE,
NgaySua DATE,
TrangThai INT , 
CONSTRAINT PK_CL PRIMARY KEY(ID)
)
go

CREATE TABLE NSX (
ID INT identity (1,1) not null  , 
MaNSX VARCHAR(10) , 
TenNSX NVARCHAR(50), 
NgayTao DATE,
NgaySua DATE,
TrangThai INT , 
CONSTRAINT PK_NSX PRIMARY KEY(ID)
)
go 

CREATE TABLE ChiTietSP (
ID INT identity (1,1) not null  , 
MaCTSP VARCHAR(10) , 
IdSP int , 
IdNSX int , 
IdDM int , 
IdCL int ,
IdMau int , 
MoTa nvarchar(50) ,
SoluongTon int , 
GiaNhap DECIMAl ,
GiaBan DECIMAl ,
NgayTao DATE,
NgaySua DATE,
TrangThai INT , 
CONSTRAINT PK_Ctsp PRIMARY KEY(ID)
)
go

CREATE TABLE NhanVien (
ID INT identity (1,1) not null  , 
MaNV VARCHAR(10) , 
TenNV NVARCHAR(50), 
NgaySinh Date , 
GioiTinh bit ,
DiaChi Nvarchar(50) , 
SDT VARCHAR(20) ,
Email VARCHAR(50) ,
Pass varchar(100) , 
IdCV int , 
TrangThai INT , 
CONSTRAINT PK_NV PRIMARY KEY(ID)
)
go 

CREATE TABLE ChucVu  (
ID INT identity (1,1) not null  , 
MaCV VARCHAR(10) , 
TenCV NVARCHAR(50),
NgayTao DATE,
NgaySua DATE,
TrangThai INT , 
CONSTRAINT PK_CV PRIMARY KEY(ID)
)
go 

CREATE TABLE KhachHang (
ID INT identity (1,1) not null  , 
MaKH VARCHAR(10) , 
TenKH NVARCHAR(50),
GioiTinh bit ,
DiaChi NVARCHAR(50),
SDT NVARCHAR(20),
Email NVARCHAR(50),
TrangThai INT , 
CONSTRAINT PK_Kh PRIMARY KEY(ID)
)
go 
CREATE TABLE GioHang (
ID INT identity (1,1) not null  , 
IdKH int , 
MaGH VARCHAR(10) , 
NgayTao Date , 
NgayThanhToan Date , 
TrangThai INT , 
CONSTRAINT PK_gh PRIMARY KEY(ID)
)
go

CREATE TABLE GioHangChiTiet (
ID INT identity (1,1) not null  ,  
IdGH int ,  
IdCTSP int , 
SoLuong int , 
DonGia Decimal , 
TrangThai int , 
CONSTRAINT PK_GHCT PRIMARY KEY(ID)
)
go 

 

CREATE TABLE HoaDon (
ID INT identity (1,1) not null  , 
IdNV int,
IdKH int ,
MaHD VARCHAR(10) , 
IdKM int ,
NgayTao Date , 
NgayThanhToan Date , 
NguoiNhan NVARCHAR(50) , 
SDT VARCHAR(20), 
DiaChi NVARCHAR(50),
TrangThai int , 
CONSTRAINT PK_HD PRIMARY KEY(ID)
)
go 
CREATE TABLE HoaDonChiTiet (
ID INT identity (1,1) not null  ,  
IdHD int ,  
IdCTSP int , 
SoLuong int , 
TrangThai int , 
CONSTRAINT PK_HDCT PRIMARY KEY(ID)
)
go 

CREATE TABLE KhuyenMai (
ID INT identity (1,1) not null  , 
MaKM VARCHAR(10) , 
TenKM NVarchar(50) , 
NgayTao Date , 
PhanTramGiam int ,
MinHoaDon decimal ,
NgayHetHan date ,
GhiChu NVarchar(50) ,
TrangThai int , 
CONSTRAINT PK_KM PRIMARY KEY(ID)
)
go 


alter table CHITIETSP add constraint fk_ctsp1 
foreign key(IdSP) references SanPham(Id)
alter table CHITIETSP add constraint fk_ctsp2 
foreign key(IdNSX) references NSX(Id)
alter table CHITIETSP add constraint fk_ctsp3
foreign key(IdDM) references DanhMuc(Id)
alter table CHITIETSP add constraint fk_ctsp4 
foreign key(IdCL) references ChatLieu(Id)
alter table CHITIETSP add constraint fk_ctsp5 
foreign key(IdMau) references Mau(Id)

go 
alter table NhanVien add constraint fk_nvcv
foreign key(IdCV) references chucvu(Id)


alter table GioHang add constraint fk_GH_KH
foreign key(IdKH) references KhachHang(Id)
alter table GioHangChiTiet add constraint fk_GH_GHCT
foreign key(IdGH) references GioHang(Id)
alter table GioHangChiTiet add constraint fk_GH_SPCT
foreign key(IdCTSP) references ChiTietSP(Id)
go 

alter table HoaDonChiTiet add constraint fk_HD
foreign key(IdHD) references HoaDon(Id)
alter table HoaDonChiTiet add constraint fk_HD_spct
foreign key(IdCTSP) references ChiTietSP(Id)
alter table HoaDon add constraint fk_hd_nv
foreign key(IdNV) references NhanVien(Id)
alter table HoaDon add constraint fk_hd_kh
foreign key(IdKH) references KhachHang(Id)
go 

Alter table HoaDon add constraint FK_HD_KM 
foreign key(IdKM) references KhuyenMai(Id)

create trigger Auto_Add_Gh on khachHang after insert as 
begin 
insert into GioHang values((select id from inserted) ,null,GETDATE(),null,1)
end