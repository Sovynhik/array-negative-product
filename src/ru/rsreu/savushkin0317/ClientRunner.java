package ru.rsreu.savushkin0317;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.savushkin0317.onedimarray.OneDimensionalIntArrayHandler;
import ru.rsreu.savushkin0317.onedimarray.productfinder.NegativeElementArrayProduct;

public class ClientRunner {
	private static final Resourcer RESOURCER = ProjectResourcer.getInstance();
	private static final int[] ARRAY_VALUES = { 0, 2, -1, 4, 1, 3, 5, -11, 9 };

	private ClientRunner() {
	}

	public static void main(String[] args) {
		final StringBuilder stringBuilder = new StringBuilder();
		final OneDimensionalIntArrayHandler arrayHandler = new OneDimensionalIntArrayHandler(ARRAY_VALUES);
		stringBuilder.append(String.format(ClientRunner.RESOURCER.getString("startArray"), arrayHandler.toString()));
		final NegativeElementArrayProduct productCalculator = new NegativeElementArrayProduct(arrayHandler);
		stringBuilder.append(productCalculator.calculateProduct());

		System.out.println(stringBuilder.toString().trim());
	}
}
