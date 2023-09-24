package org.example.bai14;

/**
 * Properties class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 20/09/2023
 */
public final class Properties {
  public static final String DB_NAME_BAI14 = "ec_java_bai14";

  class ColumnNames {
    public static final String ID = "id";
    public static final String FULL_NAME = "full_name";
    public static final String DOB = "dob";
    public static final String SEX = "sex";
    public static final String PHONE_NUMBER = "phone_number";
    public static final String UNIVERSITY_NAME = "university_name";
    public static final String GRADE_LEVEL = "grade_level";
    public static final String TYPE = "type";
    public static final String GPA = "gpa";
    public static final String BEST_REWARD_NAME = "best_reward_name";
    public static final String ENGLISH_SCORE = "english_score";
    public static final String ENTRY_TEST_SCORE = "entry_test_score";
  }

  class Query {
    public static final String INSERT_STUDENT
        = "INSERT INTO Student (full_name, dob, sex, phone_number, university_name, grade_level, "
        + "type, gpa, best_reward_name, english_score, entry_test_score) "
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String SELECT_ALL = "SELECT * FROM Student";

    public static final String SELECT_GOOD = "SELECT * FROM Student WHERE type = 0";
    public static final String SELECT_NORMAL = "SELECT * FROM Student WHERE type = 1";
  }
}
