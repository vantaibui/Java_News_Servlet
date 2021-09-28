create table Role(
	id bigint not null primary key auto_increment,
    createdate timestamp null,
    createby varchar(255) null,
    modifieddate timestamp null,
    modifiedby varchar(255) null,
    
    code varchar(20) null,
    name varchar(50) null
);

create table User(
	id bigint not null primary key auto_increment,
	createdate timestamp null,
    createby varchar(255) null,
    modifieddate timestamp null,
    modifiedby varchar(255) null,
    
    username varchar(255) not null,
    password varchar(255) not null,
    
    firstname varchar(255) null,
    lastname varchar(255) null,
    status int not null,
    
    role_id bigint not null
);

alter table User add constraint fk_user_role foreign key (role_id) references Role(id);

create table Category(
	id bigint not null primary key auto_increment,
    createdate timestamp null,
    createby varchar(255) null,
    modifieddate timestamp null,
    modifiedby varchar(255) null,
    
	code varchar(255) null,
    name varchar(255) null
);

create table News(
	id bigint not null primary key auto_increment,
	createdate timestamp null,
    createby varchar(255) null,
    modifieddate timestamp null,
    modifiedby varchar(255) null,
    
	title varchar(255) null,
    thumbnail varchar(255) null,
    shortdescription text null,
    content text null,
    
    category_id bigint not null
);

alter table News add constraint fk_News_Category foreign key (category_id) references Category(id);

create table Comment(
	id bigint not null primary key auto_increment,
	createdate timestamp null,
    createby varchar(255) null,
    modifieddate timestamp null,
    modifiedby varchar(255) null,
    
    content text null,
    user_id bigint not null,
    news_id bigint not null
);

alter table Comment add constraint fk_Comment_User foreign key (user_id) references User(id);
alter table Comment add constraint fk_Comment_News foreign key (news_id) references News(id);


insert into category(code, name) values('the-thao', 'Thể thao');
insert into category(code, name) values('the-gioi', 'Thế giới');
insert into category(code, name) values('chinh-tri', 'Chính trị');
insert into category(code, name) values('thoi-su', 'Thời sự');
insert into category(code, name) values('goc-nhin', 'Góc nhìn');

select * from category as c order by c.code desc limit 0,10;