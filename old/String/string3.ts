function firstUniqChar(s: string): number {
  const memo = new Map<string, number>();

  for (let i = 0; i < s.length; i++) {
    const temp: number | undefined = memo.get(s[i]);
    if (temp === undefined) memo.set(s[i], 1);
    if (typeof temp === "number") memo.set(s[i], temp + 1);
  }

  for (let i = 0; i < s.length; i++) {
    if (memo.get(s[i]) === 1) return i;
  }

  return -1;
}
