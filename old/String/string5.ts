function isPalindrome(s: string): boolean {
  const text: string[] = s.split("").reduce((acc: string[], c: string) => {
    if (/[A-Za-z0-9]/.test(c)) {
      acc.push(c.toLowerCase());
    }
    return acc;
  }, []);

  if (!text.length) return true;

  let left: number = 0;
  let right: number = text.length - 1;

  while (left < right) {
    if (text[left] !== text[right]) return false;
    left++;
    right--;
  }

  return true;
}
