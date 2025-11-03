package ru.rsreu.savushkin0317.onedimarray.productfinder;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.savushkin0317.onedimarray.OneDimensionalIntArrayHandler;

public class NegativeElementArrayProduct {
	private OneDimensionalIntArrayHandler handler;
	private static final Resourcer RESOURCER = ProjectResourcer.getInstance();

	public NegativeElementArrayProduct(OneDimensionalIntArrayHandler handler) {
		this.handler = handler;
	}

	public String calculateProduct() {
		int[] negativeIndices = findParametrIndices(0);

		if (!hasEnoughNegatives(negativeIndices)) {
			return NegativeElementArrayProduct.RESOURCER.getString("notEnoughNegativeNumbers");
		}

		if (areNegativesAdjacent(negativeIndices)) {
			return NegativeElementArrayProduct.RESOURCER.getString("elementsAreNextToEachOther");
		}

		return calculateProductBetweenNegatives(negativeIndices);
	}

	private int[] findParametrIndices(int valueToFind) {
		int firstIndex = -1;
		int secondIndex = -1;

		for (int i = 0; i < handler.getLength(); i++) {
			if (handler.getElement(i) < valueToFind) {
				if (firstIndex == -1) {
					firstIndex = i;
				} else if (secondIndex == -1) {
					secondIndex = i;
					break;
				}
			}
		}
		return new int[] { firstIndex, secondIndex };
	}

	private boolean hasEnoughNegatives(int[] negativeIndices) {
		return negativeIndices[1] != -1;
	}

	private boolean areNegativesAdjacent(int[] negativeIndices) {
		return negativeIndices[0] + 1 == negativeIndices[1];
	}

	private String calculateProductBetweenNegatives(int[] negativeIndices) {
		int product = 1;
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = negativeIndices[0] + 1; i < negativeIndices[1]; i++) {
			product *= handler.getElement(i);
		}

		stringBuilder.append(
				String.format(NegativeElementArrayProduct.RESOURCER.getString("productBetweenTwoNegativeElement") + product));
		return stringBuilder.toString();
	}
}
