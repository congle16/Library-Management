# Nhóm 4 - Thực Tập Công Nhân
Thực tập công nhân - Quản lý thư viện - Team 4
- Võ Đình Dũng
- Lê Chí Công
- Vương Văn Lưu
- Chanthala Saliengnak
- Sisanonh Kiattysack
- Nguyễn Lê Thiên Như

## Môi trường phát triển
- Java 8
- Java Spring Boot + Thymeleaf + Mybatis
- DB MYSQL 5.7 trở lên

## Nội dung

### Login	
	Nhập thông tin user/password để thực hiện đăng nhập
	Password mã hóa MD5
### Đăng ký user	
	Cần validate các trường user là duy nhất, địa chỉ email phải hợp lệ, số điện thoại chỉ được nhập số
### Lấy lại mật khẩu	
	Tự động tạo mật khẩu mới rồi gửi mail thông tin mật khẩu
### Thay đổi thông tin cá nhân	
	Chỉ được thay đổi thông tin của cá nhân
### Danh sách user	
	Chỉ có thủ thư và admin có chức năng này
### Sửa thông tin cá nhân	
	Thủ thư có quyền đóng user, thay đổi thông tin số điện thoại, mật khẩu, địa chỉ của user thông thường, không được quyền thay đổi role của user
	Admin có thể thay đổi thông tin số điện thoại, mật khẩu, địa chỉ, role của tất cả các user, có quyền đóng user
	
	
### Danh sách thể loại sách	
	Chỉ thủ thư và admin có quyền thực hiện
### Thêm thể loại sách
	Chỉ thủ thư và admin có quyền thực hiện
### Sửa thể loại sách
	Chỉ thủ thư và admin có quyền thực hiện
### Xóa thể loại sách	
	Chỉ thủ thư và admin có quyền thực hiện
	Trường hợp thể loại sách đang có sách thì không được xóa
	
### Danh sách sách	
	Tất cả mọi user đều có quyền
### Thêm sách, sửa sách	
	Chỉ thủ thư và admin có quyền thực hiện
### Xem nội dung sách	
	Tất cả mọi user đều có quyền
	
	
### Danh sách mượn sách	
	Với user thông thường và admin chỉ hiển thị danh sách của chính mình, với thủ thư hiển thị tất cả
	
### Mượn sách	
	Tất cả mọi user đều có quyền mượn sách, tuy nhiên cần kiểm tra sách có còn trong thư viện hay không? 
	Với mỗi một user thông thường chỉ được mượn 5 quyển, thủ thư 10 quyển, admin 15 quyển
	Không được mượn 1 quyển sách quá 30 ngày với tất cả user
	Trường hợp là user thủ thư mượn sách, trạng thái chuyển là đã duyệt và tăng thêm 1 số sách đã mượn , admin và user thông thường là pending và không tăng số sách đã mượn
### Duyệt mượn sách	
	Chỉ thủ thư có quyền duyệt sách, có thể thực hiện duyệt hoặc từ chối cho mượn sách, trường hợp duyệt, thì tăng thêm 1 số sách đã mượn.
	Trước khi duyệt, cần kiểm tra số lượng sách trong dữ liệu sách còn hay không?
### Trả sách	
	Chỉ thủ thư có quyền thao tác, khi trả sách cập nhật trạng thái và giảm đi 1 số sách đã mượn
### Mất sách	
	Chỉ thủ thư có quyền thao tác, khi báo mất sách cập nhật trạng thái và giảm đi 1 số sách đã mượn, giảm đi 1 số lượng sách

## Tham khảo
  Coding convention: Google Java Style Guide https://google.github.io/styleguide/javaguide.html
