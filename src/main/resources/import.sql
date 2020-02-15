insert into user (`name`, `email`, `created_at`, `updated_at`) values ('Anna', 'anna+1@gmail.com', '1990-02-13 15:33:25', '2020-02-13 15:33:29');
insert into user (`name`, `email`, `created_at`, `updated_at`) values ('Anna', 'anna+2@gmail.com', '1991-02-13 15:33:25', '2021-02-13 15:33:29');
insert into user (`name`, `email`, `created_at`, `updated_at`) values ('Anna', 'anna+3@gmail.com', '1992-02-13 15:33:25', '2022-02-13 15:33:29');
insert into address (`user_id`, `favorite`, `location`, `phone_number`, `created_at`, `updated_at`) values (1, 0, 'beijing', '110', '2020-02-13', '2020-02-13');
insert into address (`user_id`, `favorite`, `location`, `phone_number`, `created_at`, `updated_at`) values (1, 1, 'shanghai', '111', '2020-02-13', '2020-02-13');
insert into address (`user_id`, `favorite`, `location`, `phone_number`, `created_at`, `updated_at`) values (2, 0, 'shanghai', '112' ,'2020-02-13', '2020-02-13');
insert into product (`sku`, `description`, `price`, `created_at`, `updated_at`) values ('sku-1', 'TOP-1', 345, '2020-02-13', '2020-02-14');
insert into product (`sku`, `description`, `price`, `created_at`, `updated_at`) values ('sku-2', 'TOP-2', 12.99, '2020-02-13', '2020-02-14');
insert into product (`sku`, `description`, `price`, `created_at`, `updated_at`) values ('sku-3', 'TOP-3', '10.00', '2020-02-13', '2020-02-14');