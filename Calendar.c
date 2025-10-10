#include <stdio.h>
#include <stdlib.h>

int isLeapYear(int year) {
    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
        return 1;
    }
    return 0;
}

int getNumberOfDays(int month, int year) {
    if (month == 2) {
        if (isLeapYear(year)) {
            return 29;
        } else {
            return 28;
        }
    } else if (month == 4 || month == 6 || month == 9 || month == 11) {
        return 30;
    } else {
        return 31;
    }
}

int getFirstDayOfMonth(int month, int year) {
    static int t[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
    if (month < 3) {
        year -= 1;
    }
    return (year + year / 4 - year / 100 + year / 400 + t[month - 1] + 1) % 7;
}

void printCalendar(int month, int year) {
    char *months[] = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };

    printf("\n  =============================\n");
    printf("    %s, %d\n", months[month - 1], year);
    printf("  =============================\n");
    printf("  Sun Mon Tue Wed Thu Fri Sat\n");

    int firstDay = getFirstDayOfMonth(month, year);
    int daysInMonth = getNumberOfDays(month, year);

    for (int i = 0; i < firstDay; i++) {
        printf("    ");
    }

    for (int day = 1; day <= daysInMonth; day++) {
        printf("%4d", day);
        if ((day + firstDay) % 7 == 0) {
            printf("\n");
        }
    }
    printf("\n\n");
}

int main() {
    int year, month;

    printf("Enter the year (e.g., 2025): ");
    scanf("%d", &year);

    printf("Enter the month (1-12): ");
    scanf("%d", &month);

    if (month < 1 || month > 12 || year < 1) {
        printf("Invalid input! Please enter a valid month (1-12) and year.\n");
        return 1;
    }

    printCalendar(month, year);

    return 0;
}
