public class recursionTrees {

	//normal methods
	public static int ccCombination(int arr[], int tar, int idx, String ans) {
		
		if(tar==0) {
			System.out.println(ans);
			return 1;
		}
		
		int count=0;
		
		for(int i=idx; i<arr.length; ++i) {
			if(tar-arr[i]>=0) {
				count+=ccCombination(arr, tar-arr[i], i, ans+arr[i]);
			}
		}
		
		return count;
	}
	
	public static int ccPermutation(int arr[], int tar, String ans) {
		if(tar==0) {
			System.out.println(ans);
			return 1;
		}
		
		int count=0;
		for(int ele: arr) {
			if(tar-ele>=0) {
				count+=ccPermutation(arr, tar-ele, ans+ele);
			}
		}
		
		return count;
	}
	
	public static int ccCombinationSingle(int arr[], int tar, int idx, String ans) {
		if(tar==0) {
			System.out.println(ans);
			return 1;
		}
		
		int count=0;
		
		for(int i=idx; i<arr.length; ++i) {
			if(tar-arr[i]>=0) {
				count+=ccCombinationSingle(arr, tar-arr[i], i+1, ans+arr[i]);
			}
		}
		
		return count;
	}
	
	public static int ccPermutationSingle(int arr[], int tar, String ans) {
		if(tar==0) {
			System.out.println(ans);
			return 1;
		}
		
		int count=0;
		for(int i=0; i<arr.length; ++i) {
			int ele=arr[i];
			if(ele>0 && tar-arr[i]>=0) {
				arr[i]*=-1;
				count+=ccPermutationSingle(arr, tar-ele, ans+ele);
				arr[i]*=-1;
			}
		}
		
		return count;
	}
	
	//include exclude methods
	public static int ccCombination_sub(int arr[], int tar, int idx, String ans) {
		
		if(idx==arr.length || tar==0) {
			if(tar==0) {
				System.out.println(ans);
				return 1;
			}
			return 0;
		}
		
		int count=0;
		if(tar-arr[idx]>=0) {
			count+=ccCombination_sub(arr, tar-arr[idx], idx, ans+arr[idx]);
		}
		count+=ccCombination_sub(arr, tar, idx+1, ans);
		
		return count;
	}
	
	public static int ccPermutation_sub(int arr[], int tar, int idx, String ans) {
		
		if(idx==arr.length || tar==0) {
			if(tar==0) {
				System.out.println(ans);
				return 1;
			}
			return 0;
		}
		
		int count=0;
		if(tar-arr[idx]>=0) {
			count+=ccPermutation_sub(arr, tar-arr[idx], 0, ans+arr[idx]);
		}
		count+=ccPermutation_sub(arr, tar, idx+1, ans);
		
		return count;
	}
	
	public static int ccCombinationSingle_sub(int arr[], int tar, int idx, String ans) {
		
		if(idx==arr.length || tar==0) {
			if(tar==0) {
				System.out.println(ans);
				return 1;
			}
			return 0;
		}
		
		int count=0;
		if(tar-arr[idx]>=0) {
			count+=ccCombinationSingle_sub(arr, tar-arr[idx], idx+1, ans+arr[idx]);
		}
		count+=ccCombinationSingle_sub(arr, tar, idx+1, ans);
		
		return count;
	}
	
	public static int ccPermutationSingle_sub(int arr[], int tar, int idx, String ans) {
		
		if(idx==arr.length || tar==0) {
			if(tar==0) {
				System.out.println(ans);
				return 1;
			}
			return 0;
		}
		
		int count=0;
		int ele=arr[idx];
		if(ele>0 && tar-arr[idx]>=0) {
			arr[idx]*=-1;
			count+=ccPermutationSingle_sub(arr, tar-ele, 0, ans+ele);
			arr[idx]*=-1;
		}
		count+=ccPermutationSingle_sub(arr, tar, idx+1, ans);
		
		return count;
	}
	
	public static void main(String[] args) {

		int[] arr= {2,3,5,7};
		int tar=10;
		
		//normal methods
		
//		System.out.println(ccCombination(arr, tar, 0, ""));
//		System.out.println(ccPermutation(arr, tar, ""));
//		System.out.println(ccCombinationSingle(arr, tar, 0, ""));
//		System.out.println(ccPermutationSingle(arr, tar, ""));
		
		
		//sub methods
		
//		System.out.println(ccCombination_sub(arr, tar, 0, ""));
//		System.out.println(ccPermutation_sub(arr, tar, 0, ""));
//		System.out.println(ccCombinationSingle_sub(arr, tar, 0, ""));
		System.out.println(ccPermutationSingle_sub(arr, tar, 0, ""));
	}

}
