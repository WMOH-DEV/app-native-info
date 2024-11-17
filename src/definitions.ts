// declare module '@capacitor/core' {
//   interface PluginRegistry {
//     NativeAppInfo: NativeAppInfoPlugin;
//   }
// }

export interface NativeAppInfoPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  getAppInstaller(): Promise<{ installer: string | null }>;
  getManifestValues(): Promise<{ values: Record<string, any> }>;
}
