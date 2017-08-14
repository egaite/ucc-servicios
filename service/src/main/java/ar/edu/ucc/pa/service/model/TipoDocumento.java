package ar.edu.ucc.pa.service.model;

public enum TipoDocumento {
	DNI("Documento Unico"), LC("Libreta Civica"), LE("Libreta de Enrolamiento"), PASAPORTE(
			"Pasaporte");

	private String descripcion;

	private TipoDocumento(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
	

}
