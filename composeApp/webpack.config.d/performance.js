
// Aumentar los límites de rendimiento para evitar los avisos de "asset size limit"
// Estos avisos son normales en Compose Wasm debido al tamaño de skiko.wasm
config.performance = {
    hints: false,
    maxAssetSize: 10000000, // 10MB
    maxEntrypointSize: 10000000
};
