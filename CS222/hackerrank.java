public in addFun(int n) {
    if (n <= 0)
        return 0;
    if (n == 1)
        return 2;
    return addFun(n - 1) + addFun(n - 2);
}