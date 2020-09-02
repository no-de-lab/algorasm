/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function (nums) {
  return Object.keys(
    nums.reduce((acc, c) => {
      // 객체에 이미 존재하면 삭제 : 없으면 true 값 부여해 추가
      acc[c] ? delete acc[c] : (acc[c] = true);
      return acc;
    }, {})
  )[0];
  // return 된 객체에 남아있는 key 를 최종 return 시킴
};
