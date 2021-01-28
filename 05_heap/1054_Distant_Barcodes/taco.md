```javascript
/**
 * @param {number[]} barcodes
 * @return {number[]}
 */
var rearrangeBarcodes = function(barcodes) {
    const barcodeCount = {};
	barcodes.forEach(b => barcodeCount[b] = (barcodeCount[b] || 0) + 1);
	const elm = Object.keys(barcodeCount).sort((a, b) => barcodeCount[a] - barcodeCount[b]);
  
    let newA =[]
    let j = 1
    for(let e of elm){
        
        let cnt = barcodeCount[e];

		for (let i = 0; i < cnt; i++) {
			if (j >= barcodes.length) j = 0;
			barcodes[j] = e
			j += 2;
		}
    }
return barcodes
}
```