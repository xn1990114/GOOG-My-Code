package onsite;

import java.util.*;

/* get random point coorindate from mutiple rectangle.
 * rectangles have overlap.
*/
public class RandomPointInRectangle {
	public class Rectangle {
		double x1;
		double x2;
		double y1;
		double y2;

		public Rectangle(double x1, double y1, double x2, double y2) {
			this.x1 = Math.min(x1, x2);
			this.x2 = Math.max(x1, x2);
			this.y1 = Math.min(y1, y2);
			this.y2 = Math.max(y1, y2);
		}

		public double getArea() {
			return (y2 - y1) * (x2 - x1);
		}
	}

	class VerticalLine {
		double x;
		List<double[]> rangeToAdd;
		List<double[]> rangeToRemove;

		public VerticalLine(double x) {
			this.x = x;
			this.rangeToAdd = new ArrayList<double[]>();
			this.rangeToRemove = new ArrayList<double[]>();
		}
	}

	public double[] getRandomPoint(List<Rectangle> rectangles) {
		List<Rectangle> myRectList = new ArrayList<Rectangle>();
		breakRechAngles(myRectList, rectangles);
		double total = 0;
		Rectangle target = null;
		for (int i = 0; i < myRectList.size(); i++) {
			Rectangle curr = myRectList.get(i);
			total = total + curr.getArea();
			double ran = Math.random() * total;
			if (ran < curr.getArea()) {
				target = curr;
			}
		}
		return new double[] { target.x1 + Math.random() * (target.x2 - target.x1),
				target.y1 + Math.random() * (target.y2 - target.y1) };
	}

	public void breakRechAngles(List<Rectangle> myRectList, List<Rectangle> rectangles) {
		List<VerticalLine> vLines = new ArrayList<VerticalLine>();
		updateVerticalLineMap(vLines, rectangles);
		Collections.sort(vLines, new Comparator<VerticalLine>() {
			public int compare(VerticalLine l1, VerticalLine l2) {
				if (l1.x < l2.x) {
					return -1;
				} else if (l1.x > l2.x) {
					return 1;
				}
				return 0;
			}
		});
		List<double[]> activeRange = new ArrayList<double[]>();
		for (int i = 0; i < vLines.size() - 1; i++) {
			VerticalLine line = vLines.get(i);
			activeRange.addAll(line.rangeToAdd);
			activeRange.removeAll(line.rangeToRemove);
			Collections.sort(activeRange, new Comparator<double[]>() {
				public int compare(double[] a1, double[] a2) {
					if (a1[0] < a2[0]) {
						return -1;
					} else if (a1[0] > a2[0]) {
						return 1;
					}
					return 0;
				}
			});
			double nextX = vLines.get(i + 1).x;
			if (activeRange.size() > 0) {
				double start = activeRange.get(0)[0];
				double end = activeRange.get(0)[1];
				for (int index = 0; index < activeRange.size(); index++) {
					double[] curr = activeRange.get(index);
					if (curr[0] <= end) {
						end = Math.max(end, curr[1]);
					} else {
						myRectList.add(new Rectangle(line.x, start, nextX, end));
						start = curr[0];
						end = curr[1];
					}
				}
				myRectList.add(new Rectangle(line.x, start, nextX, end));
			}
		}
	}

	public void updateVerticalLineMap(List<VerticalLine> vLines, List<Rectangle> rectangles) {
		for (int i = 0; i < rectangles.size(); i++) {
			Rectangle currRect = rectangles.get(i);
			boolean add = false;
			boolean remove = false;
			double[] range = { currRect.y1, currRect.y2 };
			for (int j = 0; j < vLines.size(); j++) {
				VerticalLine l = vLines.get(j);
				if (Math.abs(l.x - currRect.x1) < 0.001) {
					l.rangeToAdd.add(range);
					add = true;
				}
				if (Math.abs(l.x - currRect.x2) < 0.001) {
					l.rangeToRemove.add(range);
					remove = true;
				}
			}
			if (!add) {
				VerticalLine lineToAdd = new VerticalLine(currRect.x1);
				lineToAdd.rangeToAdd.add(range);
				vLines.add(lineToAdd);
			}
			if (!remove) {
				VerticalLine lineToAdd = new VerticalLine(currRect.x2);
				lineToAdd.rangeToRemove.add(range);
				vLines.add(lineToAdd);
			}
		}
	}
}
