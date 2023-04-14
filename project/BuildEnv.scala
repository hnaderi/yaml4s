object BuildEnv {
  private val osNameOpt = sys.props.get("os.name")
  val isMacOs = osNameOpt.exists(_.toLowerCase().contains("mac"))
  val isWindows = osNameOpt.exists(_.toLowerCase().contains("windows"))
}
