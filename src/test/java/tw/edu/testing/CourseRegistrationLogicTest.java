package tw.edu.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 4. Logical Expressions Coverage：測試 {@link CourseRegistrationPolicy#canEnroll(boolean, boolean, String[])}。
 * <p>A = hasSeat，B = hasOverride，C = prerequisitesMet；P = (A OR B) AND C。
 * <p>C 由 completedCourses 控制：C = T 用 {"Calculus", "Programming"}，C = F 用 {"Calculus"}，
 * 兩者都會實際進入檢查先修課程的迴圈。
 * <p>執行：{@code mvn "-Dtest=CourseRegistrationLogicTest" test}；
 * 單一案例：{@code mvn "-Dtest=CourseRegistrationLogicTest#givenNoSeatAndOverrideAndMetPrerequisites_whenCanEnroll_thenTrue" test}。
 * <ul>
 *   <li>4-1. Predicate Coverage：{@link #givenNoSeatAndNoOverrideAndUnmetPrerequisites_whenCanEnroll_thenFalse()}、{@link #givenSeatAndOverrideAndMetPrerequisites_whenCanEnroll_thenTrue()}，最少 2 個案例；P 的 F/T 各一次。
 *   <li>4-2. Clause Coverage：{@link #givenNoSeatAndNoOverrideAndUnmetPrerequisites_whenCanEnroll_thenFalse()}、{@link #givenSeatAndOverrideAndMetPrerequisites_whenCanEnroll_thenTrue()}，最少 2 個案例；A/B/C 的 F/T 各一次。
 *   <li>4-3. Combinatorial Coverage：L1～L8，最少 8 個案例；涵蓋全部 2 × 2 × 2 種組合。
 * </ul>
 * <p>各目標共用案例，不另外增加重複測試。每個案例以下列四欄對應每週作業規定。
 */
class CourseRegistrationLogicTest {
    private final CourseRegistrationPolicy policy = new CourseRegistrationPolicy();

    /**
     * 4. Logical Expressions Coverage — L1。
     * <p>對應最少案例集合：4-1. Predicate Coverage、4-2. Clause Coverage、4-3. Combinatorial Coverage。
     * <ol>
     *   <li>Input values: hasSeat=false, hasOverride=false, completedCourses={"Calculus"}.
     *   <li>Expected result: false.
     *   <li>Test program's result: printed from the invocation below; see the homework report.
     *   <li>Criteria analysis: A=false, B=false, C=false, P=false.
     * </ol>
     */
    @Test
    void givenNoSeatAndNoOverrideAndUnmetPrerequisites_whenCanEnroll_thenFalse() {
        // Arrange
        boolean hasSeat = false;
        boolean hasOverride = false;
        String[] completedCourses = {"Calculus"};
        boolean expected = false;

        // Act
        boolean actual = policy.canEnroll(hasSeat, hasOverride, completedCourses);
        System.out.println("L1: actual=" + actual);

        // Assert
        assertEquals(expected, actual, "L1");
    }

    /**
     * 4. Logical Expressions Coverage — L2。
     * <p>對應最少案例集合：4-3. Combinatorial Coverage。
     * <ol>
     *   <li>Input values: hasSeat=false, hasOverride=false, completedCourses={"Calculus", "Programming"}.
     *   <li>Expected result: false.
     *   <li>Test program's result: printed from the invocation below; see the homework report.
     *   <li>Criteria analysis: A=false, B=false, C=true, P=false.
     * </ol>
     */
    @Test
    void givenNoSeatAndNoOverrideAndMetPrerequisites_whenCanEnroll_thenFalse() {
        // Arrange
        boolean hasSeat = false;
        boolean hasOverride = false;
        String[] completedCourses = {"Calculus", "Programming"};
        boolean expected = false;

        // Act
        boolean actual = policy.canEnroll(hasSeat, hasOverride, completedCourses);
        System.out.println("L2: actual=" + actual);

        // Assert
        assertEquals(expected, actual, "L2");
    }

    /**
     * 4. Logical Expressions Coverage — L3。
     * <p>對應最少案例集合：4-3. Combinatorial Coverage。
     * <ol>
     *   <li>Input values: hasSeat=false, hasOverride=true, completedCourses={"Calculus"}.
     *   <li>Expected result: false.
     *   <li>Test program's result: printed from the invocation below; see the homework report.
     *   <li>Criteria analysis: A=false, B=true, C=false, P=false.
     * </ol>
     */
    @Test
    void givenNoSeatAndOverrideAndUnmetPrerequisites_whenCanEnroll_thenFalse() {
        // Arrange
        boolean hasSeat = false;
        boolean hasOverride = true;
        String[] completedCourses = {"Calculus"};
        boolean expected = false;

        // Act
        boolean actual = policy.canEnroll(hasSeat, hasOverride, completedCourses);
        System.out.println("L3: actual=" + actual);

        // Assert
        assertEquals(expected, actual, "L3");
    }

    /**
     * 4. Logical Expressions Coverage — L4。
     * <p>對應最少案例集合：4-3. Combinatorial Coverage。
     * <ol>
     *   <li>Input values: hasSeat=false, hasOverride=true, completedCourses={"Calculus", "Programming"}.
     *   <li>Expected result: true.
     *   <li>Test program's result: printed from the invocation below; see the homework report.
     *   <li>Criteria analysis: A=false, B=true, C=true, P=true.
     * </ol>
     */
    @Test
    void givenNoSeatAndOverrideAndMetPrerequisites_whenCanEnroll_thenTrue() {
        // Arrange
        boolean hasSeat = false;
        boolean hasOverride = true;
        String[] completedCourses = {"Calculus", "Programming"};
        boolean expected = true;

        // Act
        boolean actual = policy.canEnroll(hasSeat, hasOverride, completedCourses);
        System.out.println("L4: actual=" + actual);

        // Assert
        assertEquals(expected, actual, "L4");
    }

    /**
     * 4. Logical Expressions Coverage — L5。
     * <p>對應最少案例集合：4-3. Combinatorial Coverage。
     * <ol>
     *   <li>Input values: hasSeat=true, hasOverride=false, completedCourses={"Calculus"}.
     *   <li>Expected result: false.
     *   <li>Test program's result: printed from the invocation below; see the homework report.
     *   <li>Criteria analysis: A=true, B=false, C=false, P=false.
     * </ol>
     */
    @Test
    void givenSeatAndNoOverrideAndUnmetPrerequisites_whenCanEnroll_thenFalse() {
        // Arrange
        boolean hasSeat = true;
        boolean hasOverride = false;
        String[] completedCourses = {"Calculus"};
        boolean expected = false;

        // Act
        boolean actual = policy.canEnroll(hasSeat, hasOverride, completedCourses);
        System.out.println("L5: actual=" + actual);

        // Assert
        assertEquals(expected, actual, "L5");
    }

    /**
     * 4. Logical Expressions Coverage — L6。
     * <p>對應最少案例集合：4-3. Combinatorial Coverage。
     * <ol>
     *   <li>Input values: hasSeat=true, hasOverride=false, completedCourses={"Calculus", "Programming"}.
     *   <li>Expected result: true.
     *   <li>Test program's result: printed from the invocation below; see the homework report.
     *   <li>Criteria analysis: A=true, B=false, C=true, P=true.
     * </ol>
     */
    @Test
    void givenSeatAndNoOverrideAndMetPrerequisites_whenCanEnroll_thenTrue() {
        // Arrange
        boolean hasSeat = true;
        boolean hasOverride = false;
        String[] completedCourses = {"Calculus", "Programming"};
        boolean expected = true;

        // Act
        boolean actual = policy.canEnroll(hasSeat, hasOverride, completedCourses);
        System.out.println("L6: actual=" + actual);

        // Assert
        assertEquals(expected, actual, "L6");
    }

    /**
     * 4. Logical Expressions Coverage — L7。
     * <p>對應最少案例集合：4-3. Combinatorial Coverage。
     * <ol>
     *   <li>Input values: hasSeat=true, hasOverride=true, completedCourses={"Calculus"}.
     *   <li>Expected result: false.
     *   <li>Test program's result: printed from the invocation below; see the homework report.
     *   <li>Criteria analysis: A=true, B=true, C=false, P=false.
     * </ol>
     */
    @Test
    void givenSeatAndOverrideAndUnmetPrerequisites_whenCanEnroll_thenFalse() {
        // Arrange
        boolean hasSeat = true;
        boolean hasOverride = true;
        String[] completedCourses = {"Calculus"};
        boolean expected = false;

        // Act
        boolean actual = policy.canEnroll(hasSeat, hasOverride, completedCourses);
        System.out.println("L7: actual=" + actual);

        // Assert
        assertEquals(expected, actual, "L7");
    }

    /**
     * 4. Logical Expressions Coverage — L8。
     * <p>對應最少案例集合：4-1. Predicate Coverage、4-2. Clause Coverage、4-3. Combinatorial Coverage。
     * <ol>
     *   <li>Input values: hasSeat=true, hasOverride=true, completedCourses={"Calculus", "Programming"}.
     *   <li>Expected result: true.
     *   <li>Test program's result: printed from the invocation below; see the homework report.
     *   <li>Criteria analysis: A=true, B=true, C=true, P=true.
     * </ol>
     */
    @Test
    void givenSeatAndOverrideAndMetPrerequisites_whenCanEnroll_thenTrue() {
        // Arrange
        boolean hasSeat = true;
        boolean hasOverride = true;
        String[] completedCourses = {"Calculus", "Programming"};
        boolean expected = true;

        // Act
        boolean actual = policy.canEnroll(hasSeat, hasOverride, completedCourses);
        System.out.println("L8: actual=" + actual);

        // Assert
        assertEquals(expected, actual, "L8");
    }
}
