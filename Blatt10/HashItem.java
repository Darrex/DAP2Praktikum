public  class HashItem
{
	private String key;
	private int info;

	public HashItem(String key)
	{
		this.key = key;
		info = 1;
	}

	public String getKey()
	{
		return key;
	}

	public int getInfo()
	{
		return info;
	}

	public void setKey(String a)
	{
		key = a;
	}

	public void setInfo(int a)
	{
		info = a;
	}				
}