alter table order_info add column package_ticket_id int(11) COMMENT '订单使用的券包券id';
alter table order_pay_info add column package_ticket_id int(11) COMMENT '订单使用的券包券id';
