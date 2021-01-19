const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const TerserPlugin = require("terser-webpack-plugin");
const nodeExternals = require('webpack-node-externals');

const config = {
    entry: './src/index.js',
    target: 'node',

    externals: [nodeExternals()],

    output: {
        filename: 'app.min.js',
        path: path.join(__dirname, 'dist'),
        publicPath: '/'
    },
    resolve:{
        extensions: ['.js']
    },
    devServer: {
        historyApiFallback: true,
    },
    optimization: {
        minimize: true,
        minimizer: [new TerserPlugin()],
    },
    module: {
        // noParse: [/bootstrap.min.css/],
        rules: [
            {
                test: /\.(js)$/,
                use: ['babel-loader'],
                exclude: /node_modules/
            },
            {
                test: /\.(css)$/,
                use: [
                    {
                        loader: "style-loader"
                    },
                    {
                        loader: "css-loader"
                    },
                ],
                exclude: /node_modules/
            },
            {
                test: /\.(png|jpe?g|gif)$/i,
                use: [
                  {
                    loader: 'file-loader',
                  },
                ],
                exclude: /node_modules/
            },
        ]
    },
    plugins: [
        new HtmlWebpackPlugin({ template: './public/index.html' }),
        // new ExtractTextPlugin({filename: '[name].css', allChunks: true}),
        // new ExtractTextPlugin("styles.css"),
    ],
}

module.exports = config;