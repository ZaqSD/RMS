package eu.rms.model;

public class SearchResult {

	private String linId = "";
	private String linStart = "";
	private String linEnd = "";

	public SearchResult(String linId, String linStart, String linEnd) {
		super();
		this.setLinId(linId);
		this.setLinStart(linStart);
		this.setLinEnd(linEnd);
	}
	
	public String getLinId() {
		return linId;
	}

	public void setLinId(String linId) {
		this.linId = linId;
	}

	public String getLinStart() {
		return linStart;
	}

	public void setLinStart(String linStart) {
		this.linStart = linStart;
	}

	public String getLinEnd() {
		return linEnd;
	}

	public void setLinEnd(String linEnd) {
		this.linEnd = linEnd;
	}

}
