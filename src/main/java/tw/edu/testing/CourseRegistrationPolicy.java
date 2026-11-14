package tw.edu.testing;

/**
 * 1114 作業：課程報名與費用計算。
 * <ul>
 *   <li>4. Logical Expressions Coverage：{@link #canEnroll(boolean, boolean, String[])}。
 *   <li>5. Input Domain Characterization：{@link #calculateFee(int, boolean)}。
 * </ul>
 */
public class CourseRegistrationPolicy {

    /** 報名本課程必須已修過的先修課程。 */
    static final String PREREQUISITE = "Programming";

    /** 團報折扣：第 2 位起每人折抵的金額。 */
    static final long GROUP_DISCOUNT = 20L;

    /**
     * 4. Logical Expressions Coverage：有名額或加簽許可，且完成先修課程，才可報名。
     * <p>先以迴圈逐一檢查已修課程，判斷是否修過 {@link #PREREQUISITE}；再以 if 判斷報名述詞。
     * <p>A = hasSeat，B = hasOverride，C = prerequisitesMet（由 completedCourses 決定）；P = (A OR B) AND C。
     * 布林 {@code |}、{@code &} 使三個子句每次都求值，不會被短路略過。
     * <ul>
     *   <li>4-1. Predicate Coverage：L1、L8，最少 2 個案例。
     *   <li>4-2. Clause Coverage：L1、L8，最少 2 個案例。
     *   <li>4-3. Combinatorial Coverage：L1～L8，最少 8 個案例。
     * </ul>
     *
     * @param hasSeat 是否有名額（子句 A）
     * @param hasOverride 是否有加簽許可（子句 B）
     * @param completedCourses 已修畢的課程名稱；含 {@link #PREREQUISITE} 時子句 C 為 true
     * @return 可報名時為 true，否則為 false
     */
    public boolean canEnroll(boolean hasSeat, boolean hasOverride, String[] completedCourses) {
        boolean prerequisitesMet = false;
        int index = 0;
        while (index < completedCourses.length) {
            if (PREREQUISITE.equals(completedCourses[index])) {
                prerequisitesMet = true;
                break;
            }
            index++;
        }
        if ((hasSeat | hasOverride) & prerequisitesMet) {
            return true;
        }
        return false;
    }

    /**
     * 5. Input Domain Characterization：標準課程每人 100，進階課程每人 200；
     * 團報時第 2 位起每人折抵 {@link #GROUP_DISCOUNT}。
     * <p>人數類別：無可計費人數（{@code <= 0}）、單人（{@code = 1}，無折扣）、多人（{@code > 1}，有折扣）。
     * 課程類別：標準（false）、進階（true）。非正人數收費為 0；以 long 累加避免溢位。
     * <ul>
     *   <li>5-1. Categorization：D1、D4、D5，最少 3 個案例。
     *   <li>5-2. Combinatorial：D1～D6，最少 6 個案例。
     * </ul>
     *
     * @param studentCount 報名人數，非正值視為無可計費人數
     * @param advancedCourse 是否為進階課程
     * @return 以 long 表示的總費用
     */
    public long calculateFee(int studentCount, boolean advancedCourse) {
        if (studentCount <= 0) {
            return 0L;
        }
        long unitFee;
        if (advancedCourse) {
            unitFee = 200L;
        } else {
            unitFee = 100L;
        }
        long total = 0L;
        for (int student = 1; student <= studentCount; student++) {
            if (student >= 2) {
                total += unitFee - GROUP_DISCOUNT;
            } else {
                total += unitFee;
            }
        }
        return total;
    }
}
