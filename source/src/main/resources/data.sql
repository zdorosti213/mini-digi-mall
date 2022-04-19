insert into provider(name) values ('NovinCharm');

insert into product (name, price, other_attributes, public_reviewable, provider_fk)
select 'leather bag', 100000, 'some_attrs', true, id from provider where name='NovinCharm';
insert into product (name, price, other_attributes, public_reviewable, provider_fk)
select 'leather gloves', 500000, 'some_attrs', true, id from provider where name='NovinCharm';
insert into product (name, price, other_attributes, public_reviewable, provider_fk)
select 'leather boots', 150000, 'some_attrs', true, id from provider where name='NovinCharm';
insert into product (name, price, other_attributes, public_reviewable, provider_fk)
select 'leather coat', 200000, 'some_attrs', true, id from provider where name='NovinCharm';

insert into comment (title, content, creation_date, vote,is_approved, product_fk)
select 'ok', 'That was good.', now(), 4.5, true, id from product p where p.name='leather bag';
insert into comment (title, content, creation_date, vote,is_approved, product_fk)
select 'excellent', 'That was very good.', now(), 5, true, id from product p where p.name='leather bag';
insert into comment (title, content, creation_date, vote,is_approved, product_fk)
select 'so so', 'That was good.', now(), 3, true, id from product p where p.name='leather gloves';
insert into comment (title, content, creation_date, vote,is_approved, product_fk)
select 'terrible', 'That was very bad.', now(), 0, false, id from product p where p.name='leather gloves';