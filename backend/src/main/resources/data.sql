INSERT INTO tb_user (name, email, password) VALUES ('Alex Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Bob Brown', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Maria Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);

INSERT INTO tb_course (name, img_Uri, img_Gray_Uri) VALUES ( 'Java', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQA4JuXTPJLdp9Ek6TDpjZLV_2lOEbF2D-MIw&usqp=CAU', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRUteJjjl50UBNg-CcR5je43nf-0zrsaaamXA&usqp=CAU' );

INSERT INTO tb_offer (edition, start_Moment, end_Moment, course_Id) VALUES ( '1.0', '2023-01-20T03:00:00Z', '2024-01-20T03:00:00Z', 1 );
INSERT INTO tb_offer (edition, start_Moment, end_Moment, course_Id) VALUES ( '2.0', '2023-05-20T03:00:00Z', '2024-05-20T03:00:00Z', 1 );

INSERT INTO tb_resource(title, description, position, img_Uri, type, offer_Id) VALUES ('Trilha Spring Boot', 'Trilha principal do curso', 1, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQA4JuXTPJLdp9Ek6TDpjZLV_2lOEbF2D-MIw&usqp=CAU', 1, 1);
INSERT INTO tb_resource(title, description, position, img_Uri, type, offer_Id) VALUES ('Forum', 'Tire suas dúvidas', 2, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQA4JuXTPJLdp9Ek6TDpjZLV_2lOEbF2D-MIw&usqp=CAU', 2, 1);
INSERT INTO tb_resource(title, description, position, img_Uri, type, offer_Id) VALUES ('Lives', 'Lives exclusivas para a turam', 3, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQA4JuXTPJLdp9Ek6TDpjZLV_2lOEbF2D-MIw&usqp=CAU', 0, 1);