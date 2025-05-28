package tsmc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//  A warehouse manager needs to create a shipment to fill a truck.
//  All of the products in the warehouse are in boxes of the same size.
//  Each product is packed in some number of units per box.
//  Given the number of boxes the truck can hold, determine the maximum number of units of any mix of products that can be shipped.
//
//  Example:
//    boxes = [1, 2, 3]
//    unitsPerBox = [3, 2, 1]
//    truckSize = 3
//
//  The maximum number of units that can be shipped is 3 + 2 + 2 = 7 units.
public class GetMaxUnits {
    public long getMaxUnits(long[] boxes, long[] unitPerBox, long truckSize) {
        List<ProductInfo> productList = new ArrayList<>();
        for (int i = 0; i < boxes.length; i++) {
            productList.add(new ProductInfo(boxes[i], unitPerBox[i]));
        }

        productList.sort((a, b) -> Long.compare(b.unitsPerBox, a.unitsPerBox)); // 降序
        long maxUnits = 0;
        for (ProductInfo product : productList) {
            if (truckSize == 0) {
                break;
            }
            long boxesToTake = Math.min(truckSize, product.numBoxes);
            maxUnits += boxesToTake * product.unitsPerBox;
            truckSize -= boxesToTake;
        }
        return maxUnits;
    }

    static class ProductInfo {
        long numBoxes;
        long unitsPerBox;
        ProductInfo(long numBoxes, long unitsPerBox) {
            this.numBoxes = numBoxes;
            this.unitsPerBox = unitsPerBox;
        }
    }
}
