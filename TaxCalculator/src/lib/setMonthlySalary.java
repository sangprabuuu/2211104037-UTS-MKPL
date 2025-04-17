public void setMonthlySalary(int grade) {
    if (grade == 1) {
        monthlySalary = 3000000;
    } else if (grade == 2) {
        monthlySalary = 5000000;
    } else if (grade == 3) {
        monthlySalary = 7000000;
    }
    
    if (isForeigner) {
        monthlySalary = (int) (monthlySalary * 1.5);
    }
}