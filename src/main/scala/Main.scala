import cats.effect.{Concurrent, ExitCode, IO, IOApp, Resource}
import cats.implicits._

object IOHalt extends IOApp {
  override def run(args: List[String]): IO[ExitCode] = contextShift.shift >> Resource.make(IO {

    System.exit(1)

  })(_ => IO(())).use { _ =>
    ???
  }
}
