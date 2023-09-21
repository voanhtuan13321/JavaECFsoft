create database ec_java_bai14;

create TABLE Student (
    id INT PRIMARY KEY IDENTITY,
    full_name NVARCHAR(50) NOT NULL DEFAULT '',
    dob DATE NOT NULL,
    sex TINYINT NOT NULL,
    phone_number VARCHAR(10) NOT NULL,
    university_name NVARCHAR(100) NOT NULL DEFAULT '',
    grade_level NVARCHAR(20) NOT NULL DEFAULT '',
    [type] TINYINT,
    gpa FLOAT DEFAULT NULL,
    best_reward_name NVARCHAR(100) DEFAULT NULL,
    english_score FLOAT CHECK(english_score >= 10 AND english_score <= 990) DEFAULT 0,
    entry_test_score FLOAT CHECK(entry_test_score >= 0 AND entry_test_score <= 10) DEFAULT 0
);

drop table Student;

INSERT INTO Student (full_name, dob, sex, phone_number, university_name, grade_level, [type], gpa,
 best_reward_name, english_score, entry_test_score)
VALUES ('Nguyen Van A', '1995-08-15', 'Male', '0901234567', 'ABC University', 'Good', 'GoodStudent', 8.5, 'Scholarship', NULL, NULL);
