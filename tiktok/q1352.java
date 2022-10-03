// 2022.10.02
// Problem Statement:
// https://leetcode.com/problems/product-of-the-last-k-numbers/

// idea: if not zero, append as normal, if is zero, from the next non-zero start the new product,
// track the last position of 0, if is included in the k last numbers, return 0,
// otherwise doesn't matter what the prefix product from 0 is, from last zero idx is enough
class ProductOfNumbers {
    private List<Integer> prefix_product;
    private int last_zero_idx;
    private int cnt;
    public ProductOfNumbers() {
        prefix_product = new ArrayList<> ();
        last_zero_idx = -1;
    }
    
    public void add(int num) {
        if (prefix_product.size()==0) {
            prefix_product.add(num);
            if (num==0) {
                last_zero_idx = prefix_product.size()-1;
            }
        } else {
            if (num!=0) {
                if (prefix_product.get(prefix_product.size()-1)!=0) prefix_product.add(num * prefix_product.get(prefix_product.size()-1));
                else prefix_product.add(num);
            } else {
                prefix_product.add(num);
                last_zero_idx = prefix_product.size()-1;
            }
        }
        return;
    }
    
    public int getProduct(int k) {
        if (last_zero_idx!=-1 && prefix_product.size()-last_zero_idx <= k) {
            return 0;
        } else {
            if (k==prefix_product.size()) {
                return prefix_product.get(prefix_product.size()-1);
            }
            return prefix_product.get(prefix_product.size()-1) / Math.max(1, prefix_product.get(prefix_product.size()-1-k));
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */