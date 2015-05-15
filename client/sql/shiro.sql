drop table if exists sys_users;
drop table if exists sys_roles;
drop table if exists sys_permissions;
drop table if exists sys_users_roles;
drop table if exists sys_roles_permissions;

create table sys_users (
  id bigint auto_increment,
  username varchar(100),
  password varchar(100),
  salt varchar(100),
  locked bool default false,
  constraint pk_sys_users primary key(id)
) charset=utf8 ENGINE=InnoDB;
create unique index idx_sys_users_username on sys_users(username);

create table sys_roles (
  id bigint auto_increment,
  role varchar(100),
  description varchar(100),
  available bool default false,
  constraint pk_sys_roles primary key(id)
) charset=utf8 ENGINE=InnoDB;
create unique index idx_sys_roles_role on sys_roles(role);

create table sys_permissions (
  id bigint auto_increment,
  permission varchar(100),
  description varchar(100),
  available bool default false,
  constraint pk_sys_permissions primary key(id)
) charset=utf8 ENGINE=InnoDB;
create unique index idx_sys_permissions_permission on sys_permissions(permission);

create table sys_users_roles (
  user_id bigint,
  role_id bigint,
  constraint pk_sys_users_roles primary key(user_id, role_id)
) charset=utf8 ENGINE=InnoDB;

create table sys_roles_permissions (
  role_id bigint,
  permission_id bigint,
  constraint pk_sys_roles_permissions primary key(role_id, permission_id)
) charset=utf8 ENGINE=InnoDB;

-- md5("password") 5f4dcc3b5aa765d61d8327deb882cf99
INSERT INTO `sys_users` (`id`, `username`, `password`, `salt`, `locked`) VALUES ('2', 't1', '5f4dcc3b5aa765d61d8327deb882cf99', '', '0');
-- SimpleHash("md5","123456","8d78869f470951332959580424d4bf4f",2) dd3736d1c3c4702e5170cde08bffd411
INSERT INTO `sys_users` (`id`, `username`, `password`, `salt`, `locked`) VALUES ('3', 't2', 'dd3736d1c3c4702e5170cde08bffd411', '8d78869f470951332959580424d4bf4f', '0');

