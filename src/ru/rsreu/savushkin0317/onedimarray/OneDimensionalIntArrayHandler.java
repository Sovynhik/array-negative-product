package ru.rsreu.savushkin0317.onedimarray;

import java.util.Arrays;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class OneDimensionalIntArrayHandler {
	private static final Resourcer RESOURCER = ProjectResourcer.getInstance();
	private int[] array;

	public OneDimensionalIntArrayHandler(int... elements) {
		this.array = elements;
	}

	public int getElement(int index) {
		if (index < 0 || index >= array.length) {
			throw new IndexOutOfBoundsException(
					String.format(OneDimensionalIntArrayHandler.RESOURCER.getString("arrayIndexOutOfBoundsException"), index));
		}
		return array[index];
	}

	public int getLength() {
		return array.length;
	}

	@Override
	public String toString() {
		return Arrays.toString(array);
	}
}
