package tw.edu.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 5. Input Domain Characterization：測試 {@link CourseRegistrationPolicy#calculateFee(int, boolean)}。
 * <p>人數分為無可計費人數（{@code <= 0}）、單人（{@code = 1}）、多人（{@code > 1}）；
 * 課程分為標準（false）、進階（true）。代表人數依序為 0、1、2。
 * <p>收費：標準每人 100、進階每人 200，團報第 2 位起每人折抵 20。
 * <ul>
 *   <li>5-1. Categorization：{@link #givenNoStudentsAndStandardCourse_whenCalculateFee_then0()}、{@link #givenOneStudentAndAdvancedCourse_whenCalculateFee_then200()}、{@link #givenTwoStudentsAndStandardCourse_whenCalculateFee_then180()}，最少 3 個案例；涵蓋全部 5 個類別。
 *   <li>5-2. Combinatorial：D1～D6，最少 6 個案例；涵蓋全部 3 × 2 種類別組合。
 * </ul>
 * <p>各目標共用案例，不另外增加重複測試。每個案例以下列四欄對應每週作業規定。
 */
class CourseRegistrationDomainTest {
    private final CourseRegistrationPolicy policy = new CourseRegistrationPolicy();

    /**
     * 5. Input Domain Characterization — D1。
     * <p>對應最少案例集合：5-1. Categorization、5-2. Combinatorial。
     * <ol>
     *   <li>Input values: studentCount=0, advancedCourse=false.
     *   <li>Expected result: 0.
     *   <li>Test program's result: printed from the invocation below; see the homework report.
     *   <li>Criteria analysis: count category=nonpositive, course category=standard.
     * </ol>
     */
    @Test
    void givenNoStudentsAndStandardCourse_whenCalculateFee_then0() {
        // Arrange
        int studentCount = 0;
        boolean advancedCourse = false;
        long expected = 0L;

        // Act
        long actual = policy.calculateFee(studentCount, advancedCourse);
        System.out.println("D1: actual=" + actual);

        // Assert
        assertEquals(expected, actual, "D1");
    }

    /**
     * 5. Input Domain Characterization — D2。
     * <p>對應最少案例集合：5-2. Combinatorial。
     * <ol>
     *   <li>Input values: studentCount=0, advancedCourse=true.
     *   <li>Expected result: 0.
     *   <li>Test program's result: printed from the invocation below; see the homework report.
     *   <li>Criteria analysis: count category=nonpositive, course category=advanced.
     * </ol>
     */
    @Test
    void givenNoStudentsAndAdvancedCourse_whenCalculateFee_then0() {
        // Arrange
        int studentCount = 0;
        boolean advancedCourse = true;
        long expected = 0L;

        // Act
        long actual = policy.calculateFee(studentCount, advancedCourse);
        System.out.println("D2: actual=" + actual);

        // Assert
        assertEquals(expected, actual, "D2");
    }

    /**
     * 5. Input Domain Characterization — D3。
     * <p>對應最少案例集合：5-2. Combinatorial。
     * <ol>
     *   <li>Input values: studentCount=1, advancedCourse=false.
     *   <li>Expected result: 100.
     *   <li>Test program's result: printed from the invocation below; see the homework report.
     *   <li>Criteria analysis: count category=one, course category=standard.
     * </ol>
     */
    @Test
    void givenOneStudentAndStandardCourse_whenCalculateFee_then100() {
        // Arrange
        int studentCount = 1;
        boolean advancedCourse = false;
        long expected = 100L;

        // Act
        long actual = policy.calculateFee(studentCount, advancedCourse);
        System.out.println("D3: actual=" + actual);

        // Assert
        assertEquals(expected, actual, "D3");
    }

    /**
     * 5. Input Domain Characterization — D4。
     * <p>對應最少案例集合：5-1. Categorization、5-2. Combinatorial。
     * <ol>
     *   <li>Input values: studentCount=1, advancedCourse=true.
     *   <li>Expected result: 200.
     *   <li>Test program's result: printed from the invocation below; see the homework report.
     *   <li>Criteria analysis: count category=one, course category=advanced.
     * </ol>
     */
    @Test
    void givenOneStudentAndAdvancedCourse_whenCalculateFee_then200() {
        // Arrange
        int studentCount = 1;
        boolean advancedCourse = true;
        long expected = 200L;

        // Act
        long actual = policy.calculateFee(studentCount, advancedCourse);
        System.out.println("D4: actual=" + actual);

        // Assert
        assertEquals(expected, actual, "D4");
    }

    /**
     * 5. Input Domain Characterization — D5。
     * <p>對應最少案例集合：5-1. Categorization、5-2. Combinatorial。
     * <ol>
     *   <li>Input values: studentCount=2, advancedCourse=false.
     *   <li>Expected result: 180 (100 + (100 - 20)).
     *   <li>Test program's result: printed from the invocation below; see the homework report.
     *   <li>Criteria analysis: count category=multiple, course category=standard.
     * </ol>
     */
    @Test
    void givenTwoStudentsAndStandardCourse_whenCalculateFee_then180() {
        // Arrange
        int studentCount = 2;
        boolean advancedCourse = false;
        long expected = 180L;

        // Act
        long actual = policy.calculateFee(studentCount, advancedCourse);
        System.out.println("D5: actual=" + actual);

        // Assert
        assertEquals(expected, actual, "D5");
    }

    /**
     * 5. Input Domain Characterization — D6。
     * <p>對應最少案例集合：5-2. Combinatorial。
     * <ol>
     *   <li>Input values: studentCount=2, advancedCourse=true.
     *   <li>Expected result: 380 (200 + (200 - 20)).
     *   <li>Test program's result: printed from the invocation below; see the homework report.
     *   <li>Criteria analysis: count category=multiple, course category=advanced.
     * </ol>
     */
    @Test
    void givenTwoStudentsAndAdvancedCourse_whenCalculateFee_then380() {
        // Arrange
        int studentCount = 2;
        boolean advancedCourse = true;
        long expected = 380L;

        // Act
        long actual = policy.calculateFee(studentCount, advancedCourse);
        System.out.println("D6: actual=" + actual);

        // Assert
        assertEquals(expected, actual, "D6");
    }
}
