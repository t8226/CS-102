
public class Codes {

	/*
	 * Encode and decode a message using a key of values stored in a queue
	 */
	
	public static void main(String[] args) 
	{
		int[] key = { 5 , 12 , -3 , 8 , -9 , 4 , 10 } ;
		Integer keyValue ;
		String encoded = "" , decoded = "" ;
		String message = "All programmers are playwrights and all computers are lousy actors." ;
		CircularArrayQueue<Integer> encodingQueue = new CircularArrayQueue<Integer>() ;
		CircularArrayQueue<Integer> decodingQueue = new CircularArrayQueue<Integer>() ;
		
		// Load key queues
		
		for( int scan = 0 ; scan < message.length(); scan++ )
		{
			encodingQueue.enqueue( key [ scan ] ) ;
			decodingQueue.enqueue( key [ scan ] ) ;
		}
		
		// Encode message
		
		for( int scan = 0 ; scan < message.length() ; scan ++ )
		{
			keyValue = encodingQueue.dequeue() ;
			encoded += ( char ) ( message.charAt( scan ) + keyValue ) ;
			encodingQueue.enqueue( keyValue ) ;
		}
		
		System.out.println( "Encoded Message:\n" + encoded + "\n" ) ;
		
		// Decode message
		
		for( int scan = 0 ; scan < encoded.length() ; scan++ )
		{
			keyValue = decodingQueue.dequeue() ;
			decoded += ( char ) ( encoded.charAt( scan ) - keyValue ) ;
			decodingQueue.enqueue( keyValue ) ;
		}
		
		System.out.println( "Decoded Message:\n" + decoded + "\n" ) ;
	}

}
