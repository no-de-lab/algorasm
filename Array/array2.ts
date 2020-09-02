function maxProfit(prices: number[]): number {
  return prices.reduce(
    (profit: number, c: number, i: number, array: number[]): number => {
      if (array[i - 1] < c) profit += c - array[i - 1];
      return profit;
    },
    0
  );
}

console.log(maxProfit([1, 2, 3, 4, 5]));
