INSERT INTO teachers(teacher_id, name, surname, age)
VALUES
('67167cd2-9ecd-451f-a19d-6b8c730e4090','Vasilina', 'Kravchenko', 38),
('c26ad20b-6f01-4b55-ba84-05b4df9e38ca', 'Olga', 'Baranova', 43),
('acbb9b7d-6609-4e63-b07d-c7cb5a6715b5', 'Nikolay', 'Ranov', 53),
('82026bd4-7b85-43d0-801e-273df480cba2', 'Andrey', 'Smith', 32),
('1e337ca3-5939-4ed8-9efa-ea121f81ffde', 'Mary', 'Williams', 45),
('80b4bf2d-010d-4d21-a266-36ae0e54a5ca', 'Alina', 'Taranova', 34);

INSERT INTO groups(group_id, group_name)
VALUES
('8d690a59-37c3-4d0c-95b4-e9ea3dab3403', 'BR-1'),
('ab171cbc-0b9d-4528-b726-b646cde36da7', 'ET-3'),
('fbd710e0-b620-45cf-9c72-449776cfbe65', 'AE-2'),
('1d3dc1dd-6737-4bd7-ab53-42284dde8087', 'DS-4');

INSERT INTO subjects(subject_id, name_of_subject)
VALUES
('31390f22-0791-4851-950c-5f2e7205b475', 'Math'),
('c1114452-29fd-4be0-a46b-b91d40bc7e6a', 'Geography'),
('46310928-c221-446a-9a67-afd419943581', 'Biology'),
('2b7499f4-e819-43c8-8798-4e52b8a134a6', 'Law'),
('4d12be95-2b09-4bf3-8985-280840c3617e', 'Economics'),
('4fe7ad1c-00c1-44d2-b573-6910be763484', 'Business'),
('d5fe75a1-8307-44e8-9658-83e25fe10914', 'English'),
('7c479327-c461-49fa-8679-710d7daecc63', 'Technology'),
('bd7b4366-dbd6-4c77-9336-81bca7c52832', 'Information');

INSERT INTO students(student_id, name, surname, age, date_of_admission, group_id)
VALUES
('837cc9c5-951d-49bc-83a4-2444d2eb85fd', 'Lev', 'Krun', 21, '2022-04-15 11:12:22',(SELECT group_id FROM groups WHERE group_name = 'BR-1')),
('033e58d9-49a0-4c28-bf64-11646531f484', 'Lina', 'Kostenko', 19, '2022-04-15 12:10:25',(SELECT group_id FROM groups WHERE group_name = 'BR-1')),
('0a8f8e91-6b97-4e2a-828d-8e59dc33173d', 'Valeria', 'Shapran', 22, '2022-04-15 12:34:06',(SELECT group_id FROM groups WHERE group_name = 'ET-3')),
('d3e94c06-8c75-436e-ade4-5b014faf56c9', 'Alexandr', 'Borisov', 18, '2022-04-15 13:43:12',(SELECT group_id FROM groups WHERE group_name = 'ET-3')),
('f599dc17-34fd-40f4-9284-87e699fbc7d2', 'Inna', 'Tkachukn', 21, '2022-04-15 13:15:43',(SELECT group_id FROM groups WHERE group_name = 'AE-2')),
('4ec0a95d-20e5-4811-9b05-41adaa84f892', 'Ksenia', 'Kovalenko', 23, '2022-04-15 13:21:24',(SELECT group_id FROM groups WHERE group_name = 'AE-2')),
('1f90539b-43f1-4bfa-9871-8e4e19dd2745', 'Lubov', 'Kohut', 21, '2022-04-15 14:10:54',(SELECT group_id FROM groups WHERE group_name = 'DS-4')),
('f203e88a-0d0e-4e09-b5b9-b4763cba5299', 'Maxim', 'Sobol', 22, '2022-04-15 14:10:28',(SELECT group_id FROM groups WHERE group_name = 'DS-4')),
('503a0922-4e15-4559-b918-109e3b5f37da', 'Andriy', 'Boiko', 17, '2022-04-15 14:47:15',(SELECT group_id FROM groups WHERE group_name = 'BR-1')),
('f8af43b8-9826-4d97-8256-0d793c546903', 'Yuriy', 'Chayka', 22, '2022-04-15 15:14:32',(SELECT group_id FROM groups WHERE group_name = 'AE-2'));

INSERT INTO grades(grade_id, subject_id, mark, student_id)
VALUES
('1d925257-7bb0-4e46-a0f7-868cc6cef7ca', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Math'), 79, (SELECT student_id FROM students WHERE name = 'Lev' AND surname = 'Krun')),
('5088a982-c84b-44c7-b351-9a7c407a261d', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Law'), 93, (SELECT student_id FROM students WHERE name = 'Lev' AND surname = 'Krun')),
('1da71f95-b6cd-476c-a3be-ca9372be2444', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Information'), 78, (SELECT student_id FROM students WHERE name = 'Lev' AND surname = 'Krun')),
('bbc315a0-d56e-495d-9f0d-10202e93cdf8', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Information'), 92, (SELECT student_id FROM students WHERE name = 'Lina' AND surname = 'Kostenko')),
('fae7a0a9-418f-4e02-8ca5-861d2dd53072', (SELECT subject_id FROM subjects WHERE name_of_subject = 'English'), 87, (SELECT student_id FROM students WHERE name = 'Lina' AND surname = 'Kostenko')),
('5da02938-5603-4ef8-b056-f56ca6571dac', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Business'), 93, (SELECT student_id FROM students WHERE name = 'Lina' AND surname = 'Kostenko')),
('0f636b98-965b-4165-bbd4-a7ce279753d3', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Business'), 85, (SELECT student_id FROM students WHERE name = 'Valeria' AND surname = 'Shapran')),
('8c5c0bbf-7ebc-46e0-b12b-453dc34f97e0', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Economics'), 89, (SELECT student_id FROM students WHERE name = 'Valeria' AND surname = 'Shapran')),
('158ffffc-e834-4835-a873-5ab0d6cc86e5', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Law'), 79, (SELECT student_id FROM students WHERE name = 'Valeria' AND surname = 'Shapran')),
('3b445889-4a53-4357-8cfb-616f0897b89f', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Geography'),68 , (SELECT student_id FROM students WHERE name = 'Alexandr' AND surname = 'Borisov')),
('e7d55185-e89f-4c47-ba9d-4dd1930c5d7a', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Biology'),74 , (SELECT student_id FROM students WHERE name = 'Alexandr' AND surname = 'Borisov')),
('453db25a-3158-4c4b-8d68-b0c0cfbe8342', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Math'),70 , (SELECT student_id FROM students WHERE name = 'Alexandr' AND surname = 'Borisov')),
('6d13cb97-d877-4c16-a2b8-e54f90fded1d', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Math'),80 , (SELECT student_id FROM students WHERE name = 'Inna' AND surname = 'Tkachukn')),
('ae9bb043-6554-44fd-93be-9e2115e5559e', (SELECT subject_id FROM subjects WHERE name_of_subject = 'English'),99 , (SELECT student_id FROM students WHERE name = 'Inna' AND surname = 'Tkachukn')),
('d70e8aae-a18e-4781-bc33-93ed4b501623', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Law'),95 , (SELECT student_id FROM students WHERE name = 'Inna' AND surname = 'Tkachukn')),
('06c10b1d-cb37-4fad-8739-04e5353621f5', (SELECT subject_id FROM subjects WHERE name_of_subject = 'English'),78 , (SELECT student_id FROM students WHERE name = 'Ksenia' AND surname = 'Kovalenko')),
('99940cd6-ce1d-4465-8eb9-90a842b78539', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Technology'),93 , (SELECT student_id FROM students WHERE name = 'Ksenia' AND surname = 'Kovalenko')),
('8cb5555b-34dd-4625-a774-e9064651e559', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Information'),89 , (SELECT student_id FROM students WHERE name = 'Ksenia' AND surname = 'Kovalenko')),
('8e51e43d-ebe1-4dd5-b5b9-2db0a0cd07aa', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Business'),76 , (SELECT student_id FROM students WHERE name = 'Lubov' AND surname = 'Kohut')),
('218c987c-419e-41d1-ac94-dac5ee728d36', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Information'),70, (SELECT student_id FROM students WHERE name = 'Lubov' AND surname = 'Kohut')),
('15dfa9d2-3e99-4b03-bea7-da1ee0d10cf1', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Law'),73 , (SELECT student_id FROM students WHERE name = 'Lubov' AND surname = 'Kohut')),
('c1d139e3-b43d-4d25-a85a-477154596587', (SELECT subject_id FROM subjects WHERE name_of_subject = 'English'),80 , (SELECT student_id FROM students WHERE name = 'Maxim' AND surname = 'Sobol')),
('5dcefada-1b2d-4ec2-a2d3-d97d6c5db910', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Biology'),85 , (SELECT student_id FROM students WHERE name = 'Maxim' AND surname = 'Sobol')),
('33ad822c-ae55-42f0-a1d5-2e5490b2e1fb', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Math'),88 , (SELECT student_id FROM students WHERE name = 'Maxim' AND surname = 'Sobol')),
('1c44a86f-5e67-4131-9132-a07ce4d807c1', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Economics'),88 , (SELECT student_id FROM students WHERE name = 'Andriy' AND surname = 'Boiko')),
('3664cf44-a631-420a-a95d-bde70eb02589', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Geography'),78, (SELECT student_id FROM students WHERE name = 'Andriy' AND surname = 'Boiko')),
('90122499-ba42-4555-8ba8-abb54bbf8607', (SELECT subject_id FROM subjects WHERE name_of_subject = 'English'),81 , (SELECT student_id FROM students WHERE name = 'Andriy' AND surname = 'Boiko')),
('d6a08d18-ae05-41c2-b8d2-6089802e27e0', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Information'),73 , (SELECT student_id FROM students WHERE name = 'Yuriy' AND surname = 'Chayka')),
('e2e6c5a4-b55f-4c61-8ae8-4e1de9b95e5e', (SELECT subject_id FROM subjects WHERE name_of_subject = 'Geography'),86 , (SELECT student_id FROM students WHERE name = 'Yuriy' AND surname = 'Chayka')),
('e72c3b5c-3c3e-47e1-8c68-260b0afc1ca8', (SELECT subject_id FROM subjects WHERE name_of_subject = 'English'),87 , (SELECT student_id FROM students WHERE name = 'Yuriy' AND surname = 'Chayka'));






















