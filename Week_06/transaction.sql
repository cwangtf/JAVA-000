CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) NOT NULL DEFAULT '' COMMENT '昵称',
  `phone_num` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号',
  `real_name` varchar(255) DEFAULT '' COMMENT '真实姓名',
  `id_card_no` varchar(20) DEFAULT '' COMMENT '身份证号',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '软删除(0未删，1删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

CREATE TABLE `product` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '商品名',
  `product_pic` varchar(255) NOT NULL DEFAULT '' COMMENT '商品图片',
  `product_description` varchar(255) DEFAULT '' COMMENT '商品描述',
  `product_detail` text COMMENT '商品详情',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(255) unsigned NOT NULL DEFAULT '0' COMMENT '软删除(0未删，1删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品表';

CREATE TABLE `product_sku` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sku_name` varchar(255) NOT NULL DEFAULT '' COMMENT '规格名',
  `stock_num` bigint(20) unsigned NOT NULL COMMENT '库存',
  `sku_pic` varchar(255) NOT NULL COMMENT '规格图片',
  `product_id` bigint(20) NOT NULL COMMENT '=product.id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(1) NOT NULL COMMENT '软删除(0未删，1删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品规格';

CREATE TABLE `order` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `order_no` varchar(255) NOT NULL COMMENT '订单号',
  `sku_id` bigint(20) unsigned NOT NULL COMMENT '=sku.id',
  `user_id` bigint(20) NOT NULL COMMENT '=user.id',
  `receiver_phone` varchar(20) NOT NULL COMMENT '收货人手机号',
  `receiver_name` varchar(255) NOT NULL COMMENT '收货人姓名',
  `receiver_address` varchar(255) NOT NULL COMMENT '收货人地址',
  `origin_price` bigint(20) NOT NULL COMMENT '原价(单位:分)',
  `discount_price` bigint(20) NOT NULL COMMENT '优惠金额(单位:分)',
  `paid` bigint(20) NOT NULL COMMENT '实付金额(单位:分)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '软删除(0未删，1删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';
