export interface NativeAppInfoPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
