function isAnagram(s: string, t: string): boolean {
  let answer: boolean;
  const map = new Map<string, number>();

  for (let i = 0; i < s.length; i++) {
    const temp: number | undefined = map.get(s[i]);
    if (temp === undefined) map.set(s[i], 1);
    else map.set(s[i], temp + 1);
  }

  for (let i = 0; i < t.length; i++) {
    const temp: number | undefined = map.get(t[i]);
    if (!temp) return false;
    else {
      if (temp - 1) map.set(t[i], temp - 1);
      else map.delete(t[i]);
    }
  }

  return map.size === 0;
}

console.log(isAnagram("ab", "a"));
console.log(isAnagram("a", "aa"));
