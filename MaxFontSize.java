/*
The goal of this program is to find the maximum font size that can be used on a String to fit it into a textbox.

2 helper functions are available:
int getFontWidth(Char c, int fontSize)
int getFontHeight(int fontSize)
*/

public int maxPossibleSize(String s, int minSize, int maxSize, int width, int height)
{
	int maxFontSize = -1;
	if (maxSize < minSize)
	{
		return -1;
	}

	int middleSize = (maxSize + minSize) / 2;

	if (fits(s, middleSize, width, height))
	{
		maxFontSize = Math.max(maxPossibleSize(s, middleSize + 1, maxSize, width, height), middleSize);
	}
	else
	{
		maxFontSize = maxPossibleSize(s, minSize, middleSize - 1, width, height);
	}

	return maxFontSize;
}

public boolean fits(String s, int fontSize, int width, int height)
{
	if (getFontHeight(fontSize) > height)
	{
		return false;
	}

	int linesNeeded = 1;
	int remainingWidth = width;
	Char[] chars = s.toCharArray();

	for (int i = 0; i < chars.length; i++)
	{
		if (getFontWidth(chars[i], fontSize) > width)
		{
			return false;
		}
		remainingWidth -= getFontWidth(chars[i], fontSize);
		if (remainingWidth < 0)
		{
			linesNeeded++;
			remainingWidth = width - getFontWidth(chars[i], fontSize);
		}
	}

	int linesPossible = height / getFontHeight(fontSize);

	if (linesNeeded > linesPossible)
	{
		return false;
	}

	return true;
}