package ar.edu.ucc.pa.service.exceptions;

public class ResponseErrorStatus {
	
private String codigo;
	
	private String mensaje;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public ResponseErrorStatus(String codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}
	
	public ResponseErrorStatus() {
		super();
		this.codigo = "0";
		this.mensaje = "OK";
	}

}
