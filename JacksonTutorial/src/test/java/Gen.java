
public class Gen<T extends Number>
{
	T obj;
	
	Gen()
	{
		
	}
	
	Gen(T obj)
	{
		this.obj=obj;
	}

	public void show()
	{
		System.out.println("The class type is:"+ obj.getClass().getName());
	}
	
	public T getObject()
	{
		return obj;
	}
	
}
